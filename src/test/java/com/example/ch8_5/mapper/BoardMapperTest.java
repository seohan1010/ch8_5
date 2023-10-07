package com.example.ch8_5.mapper;

import com.example.ch8_5.to.BoardDto;
import com.example.ch8_5.to.SearchCondition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;


    @Test
    public void test() {
        System.out.println("<<<<<<<<<<< boardMapper = " + boardMapper);
        assertNotNull(boardMapper);
    }

    @Test
    public void selectBoardListTest() throws Exception {


        int boardCnt = boardMapper.selectBoardCnt();
        System.out.println("<<<<<<<<<<<< boardCnt = " + boardCnt);
    }


    @Test
    public void selectByOffsetTest()throws Exception{

        Integer offset = 20;
        Integer pageSize = 10;

        SearchCondition sc = new SearchCondition();
        sc.setOffset(offset);
        sc.setPageSize(pageSize);

       List<BoardDto> list = boardMapper.selectBoardList(sc);
       list.forEach(System.out::println);

    }


}