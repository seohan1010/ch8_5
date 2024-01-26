package com.example.ch8_5.controller;


import com.example.ch8_5.mapper.BoardFileMapper;
import com.example.ch8_5.to.BoardFileDto;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


// 이번 컨트롤러 부터는 logger를 사용해서 로깅을 하도록 하겠습니다.

@RestController
@RequestMapping(value = "/file")
public class BoardFileController {


    BoardFileMapper boardFileMapper;

    @Autowired
    public BoardFileController(BoardFileMapper boardFileMapper) {
        this.boardFileMapper = boardFileMapper;
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    // application.properties 파일에 저장될 경로를 작성해 두었다.
    @Value("${spring.servlet.multipart.location}")
    private String filepath;

    /*
        특정 게시물에 해당하는 파일의 이름을 프론트단에 전송해주는 컨트롤러가 필요하다
        ---> 이거는 게시판이 상세 페이지가 다 만들어지고 나서 하면은 좋을거 같다.
     */


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFile(@RequestParam("filename") String filename, @RequestParam("file_no") Long file_no) {
        logger.info("filename : {}", filename);


        File file = new File(filepath + filename);

        // 파일이 잘 삭제가 되었는지의 여부에 따라서 분기를 해준다.
        boolean bool = file.delete();
        if (bool) {
            try {
                boardFileMapper.deleteBoardFile(file_no);
                logger.info("file.delete() : {}", bool);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // 파일이 저장되는 디렉토리에 같은 이름의 파일이 있는지 확인하고
    // 같은 이름의 파일이 있으면은 새롭게 저장하는 파일을 복사 해놓고
    // 해당 파일의 이름을 변경한 다음에 upload 디렉토리에 저장한다.
    // 변경한 다음에 저장한다.
    // 같은 이름의 파일이 있으면은 해당 파일의 이름에 "복사본 이라는 단어가 있는지 확인"
    // (이때 해당 파일의 임시파일을 다른 디렉토리 혹은 저장 가능한 곳에 저장해놓고
    // 해당 파일의 이름을 변경한 다음에 다시 업로드 디렉토리로 가지고 온다.
    // )
    // 복사본 이라는 단어가 있으면은 "복사본1" 이렇게 뒤에 숫자가 붙어 있는 지를 확인하고
    // 숫자가 붙어 있으면은 모든 이름들을 TreeSet에 넣어서 가장 마지막 이름을 가져와서
    // 마지막 이름의 숫자에 1을 더한 이름을 새로 저장하는 파일의 이름으로 설정한다.
    // ---> 이거를 메서드를 생성해서 분기 처리를 해주어야 겠다.
    //      개발 진전이 없다.

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<List<String>> uploadFile(MultipartFile[] files, @RequestParam("bno") String bno) {
        List<String> list = new ArrayList<>(); // 저장된 파일의 이름을 저장할 List

        BoardFileDto boardFileDto = new BoardFileDto();
        String filename = "";


        try {

            for (MultipartFile file : files) {

                System.out.println("filename = file.getName() = " + file.getName());
                File existFile = new File(filepath, file.getOriginalFilename());
                if (existFile.exists()){

                    System.out.println("file already exist.");
                    

                }else{
                    file.transferTo(existFile);
                }

            }


            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        }

    }

    // 이때 확장명 ex).jpg , .png etc 이러한 것들도 붙여 주어야한다.
    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadFile(@RequestParam("filename") String filename) {

        Resource resource = null;
        try {
            System.out.println("filename = " + filename);
            resource = new FileSystemResource(filepath + filename);
            return new ResponseEntity<>(resource, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(resource, HttpStatus.BAD_REQUEST);
        }


    }

}
