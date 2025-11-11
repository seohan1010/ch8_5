package com.example.ch8_5.mapper;

import com.example.ch8_5.to.BoardFileDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardFileMapperTest {


    @Autowired
    BoardFileMapper boardFileMapper;
    
    
    @Test
    public void test(){
        System.out.println("<<<<<<< boardFileMapper = " + boardFileMapper);
    }

    @Test
    public void selectTest(){
        Long bno = 5l;
        try {
            List<BoardFileDto> list = boardFileMapper.selectBoardFileNameList(bno);

            assertNotNull(list);
            System.out.printf("%n");
            System.out.printf("%n");
            System.out.printf("%n");
            list.forEach(System.out::println);
            System.out.printf("%n");
            System.out.printf("%n");
            System.out.printf("%n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
}