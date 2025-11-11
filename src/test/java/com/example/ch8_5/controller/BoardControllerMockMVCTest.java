package com.example.ch8_5.controller;

import com.example.ch8_5.service.BoardService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value=BoardController.class)
class BoardControllerMockMVCTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BoardService boardService;





}