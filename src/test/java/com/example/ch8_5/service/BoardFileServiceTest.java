package com.example.ch8_5.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BoardFileServiceTest {

    // application.properties 파일에 저장될 경로를 작성해 두었다.
    @Value("${spring.servlet.multipart.location}")
    private String filepath;



    @Test
    public void fileTest(){

        int fileCnt=0;
        int dirCnt=0;

        File file = new File(filepath);

        while(file.isFile()){
            fileCnt+=1;
        }
        while(file.isDirectory()){
            dirCnt+=1;
        }

        System.out.printf("fileCnt : %d. dirCnt : %d ",fileCnt,dirCnt);



    }

}