package com.example.ch8_5.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


// 이번 컨트롤러 부터는 logger를 사용해서 로깅을 하도록 하겠습니다.

@RestController
@RequestMapping(value = "/file")
public class FileController {

   private Logger logger = LoggerFactory.getLogger(getClass());

    // application.properties 파일에 저장될 경로를 작성해 두었다.
    @Value("${spring.servlet.multipart.location}")
    private String filepath;

    /*
        특정 게시물에 해당하는 파일의 이름을 프론트단에 전송해주는 컨트롤러가 필요하다
        ---> 이거는 게시판이 상세 페이지가 다 만들어지고 나서 하면은 좋을거 같다.
     */


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteFile(@RequestParam("filename") String filename) {
        logger.info("filename : {}",filename);
        System.out.println("filename = " + filename);

        File file = new File(filepath + filename);

        // 파일이 잘 삭제가 되었는지의 여부에 따라서 분기를 해준다.
        if (file.delete() == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // 파일이 저장되는 디렉토리에 같은 이름의 파일이 있는지 확인하고
    // 같은 이름의 파일이 있으면은 새롭게 저장하는 파일의 이름을
    // 변경한 다음에 저장한다.
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<List<String>> uploadFile(MultipartFile[] files) {
        List<String> list = new ArrayList<>();



        try {
            for (MultipartFile file : files) {

                File upFile = new File(filepath, file.getOriginalFilename());
                    logger.info("filename : {} ",file.getOriginalFilename());
                    logger.info("fileSize : {} ",file.getSize());
                if (!upFile.exists()) {
                    file.transferTo(upFile); // 업로드된 파일을 지정된 경로에 저장
                    list.add(file.getOriginalFilename());
                }

            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        }

    }


    @RequestMapping(value = "/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadFile(String filename) {

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
