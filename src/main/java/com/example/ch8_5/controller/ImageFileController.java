package com.example.ch8_5.controller;

import net.bytebuddy.utility.FileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.resource.PathResourceResolver;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.FilenameFilter;
import java.net.FileNameMap;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping(value = "/image")
public class ImageFileController {

    @Value("${spring.servlet.multipart.location}")
    private String filepath;

    private Logger logger = LoggerFactory.getLogger(getClass());


    public void findFiles(File file) {
        int numberOfFiles = 0;
        int numberOfDirectory = 0;



        if (file.isFile()) {
            System.out.println("directory.getAbsolutePath() = " + file.getAbsolutePath());
            numberOfFiles++;

        } else {
            numberOfDirectory++;
            File[] filese = file.listFiles();
            for (File file1 : filese) {
                // 재귀 호출을 하려는거 같다.
                findFiles(file1);
            }
        }
    }

    // 업로드할 디렉토리에 중복되는 이름이 있으면은 새로 업로드할 파일의 이름을
    // 새로 생성해서 업로드 한다.
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> uploadImage(MultipartFile[] files, @RequestParam("bno") Long bno) {

        System.out.println("<<<<<<<<<<< bno = " + bno);
        File directory = new File(filepath);
        findFiles(directory);

        return new ResponseEntity<>(HttpStatus.OK);

    }


}
