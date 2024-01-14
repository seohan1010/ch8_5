package com.example.ch8_5.to;

import com.example.ch8_5.mapper.BoardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PageHandlerTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void test() throws Exception {

        Long cnt = boardMapper.selectBoardCnt();

        SearchCondition sc = new SearchCondition();
        sc.setPage(2);
        sc.setPageSize(10);
        PageHandler ph = new PageHandler(cnt,sc);
        ph.print();


    }


}