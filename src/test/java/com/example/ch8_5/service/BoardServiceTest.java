package com.example.ch8_5.service;

import com.example.ch8_5.mapper.BoardMapper;
import com.example.ch8_5.to.SearchCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.BooleanString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void test() throws Exception {

        SearchCondition sc = new SearchCondition();
        sc.setPageSize(10);
        sc.setPage(1);
        sc.setKeyword("1");
        sc.setOption("T");
        Long cnt = boardMapper.selectBoardCntBySearchCondition(sc);
        System.out.println("cnt = " + cnt);
    }


}