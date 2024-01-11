package com.example.ch8_5.to;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PageHandlerTest {


    @Test
    public void test() {
        PageHandler ph = new PageHandler(22, 265);
        ph.print();
        System.out.println("totalPage is : " + ph.totalPage);

        System.out.println("ph.beginPage = " + ph.beginPage);
        System.out.println("ph.endPage = " + ph.endPage);
        assertTrue(ph.beginPage == 21);
        assertTrue(ph.endPage == 27);


    }


}