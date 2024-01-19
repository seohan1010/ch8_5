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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> uploadImage(MultipartFile[] files) {

        String filename = "singapore.jpg";

        File directory = new File(filepath);


        for (MultipartFile file : files) {


            FilenameFilter filter = (dir, name) ->
                    !name.equals(file.getOriginalFilename());


            String[] arr = directory.list(filter);
            System.out.println("arr = " + Arrays.toString(arr));
            System.out.println("file.getContentType() = " + file.getContentType());

        }


        return new ResponseEntity<>(HttpStatus.OK);

    }


}
