package com.example.ch8_5.controller;


import com.example.ch8_5.mapper.BoardFileMapper;
import com.example.ch8_5.to.BoardFileDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


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
    // 같은 이름의 파일이 있으면은 새롭게 저장하는 파일의 이름을
    // 변경한 다음에 저장한다.
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<List<String>> uploadFile(MultipartFile[] files, @RequestParam("bno") String bno) {
        List<String> list = new ArrayList<>();

        BoardFileDto boardFileDto = new BoardFileDto();

        try {
            for (MultipartFile file : files) {

                File upFile = new File(filepath, file.getOriginalFilename());
                logger.info("<<<<<<<<<  filename : {} ", file.getOriginalFilename());
                logger.info("<<<<<<<<<  fileSize : {} ", file.getSize());
                logger.info("<<<<<<<<< filetype : {}", file.getContentType());
                // 해당 파일이름이 존재하지 않으면은 파일을 업로드
                if (!upFile.exists()) {
                    file.transferTo(upFile); // 업로드된 파일을 지정된 경로에 저장
                    list.add(file.getOriginalFilename());
                    boardFileDto.setBno(bno);
                    boardFileDto.setFileName(file.getOriginalFilename());
                    boardFileDto.setFilePath(filepath);
//                    boardFileMapper.insetBoardFile(boardFileDto);

                    // 해당 파일이름이 존재하면은 새로 업로드할 파일의 이름을 새로 생성한
                    // 다음에 파일을 업로드
                } else if (upFile.exists()) {
                    // 나중에는 이름을 "."를 구분자로 나눈다음에 파일명을 변경한후 다시 합치는 로직을
                    // 적용해보자.
                    File newFile = new File(filepath, file.getOriginalFilename());


                    newFile.renameTo(new File(filepath + Instant.now() + file.getOriginalFilename()));
                    logger.info("<<<<<<< newFile.getName() : {}", newFile.getName());

                    file.transferTo(newFile);
                    boardFileDto.setBno(bno);
                    boardFileDto.setFileName(newFile.getName());
                    boardFileDto.setFilePath(filepath);
//                    boardFileMapper.insetBoardFile(boardFileDto);

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
