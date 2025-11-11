package com.example.ch8_5.controller;

import com.example.ch8_5.service.BoardService;
import com.example.ch8_5.to.ChatbotMsg;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(value=BoardController.class)
@WebMvcTest(ChatbotController.class) // 특정 컨트롤러만 테스트
@AutoConfigureMockMvc
public class ChatBotMockMVCTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void chatBotTest()throws Exception{

        ChatbotMsg chatbotMsg = new ChatbotMsg();
        chatbotMsg.setUser("testUser");
        chatbotMsg.setMessage("testMessage");
        chatbotMsg.setChatNum(12345L);

        ResultActions resultActions =  mockMvc.perform(MockMvcRequestBuilders.post("/chatbot/retrieve_msg")
                                              .contentType(MediaType.APPLICATION_JSON)
                                              .content(objectMapper.writeValueAsBytes(chatbotMsg)));


        resultActions
                .andExpect(status().isBadRequest())
                .andDo(result -> System.out.println("result = " + result) );

    }

}