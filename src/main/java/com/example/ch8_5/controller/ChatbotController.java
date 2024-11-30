package com.example.ch8_5.controller;

import com.example.ch8_5.to.ChatbotMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000", "*"})
@RestController
@RequestMapping(value = "/chatbot")
public class ChatbotController {
    Map<String, Object> map = null;

    @RequestMapping(value = "/retrieve_msg", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> retrieveChatbotMsg(@RequestBody ChatbotMsg req) {

        System.out.println(req);

    try {
        map = new HashMap<>();
        map.clear();
        map.put("message",req.toString());
        // 유효한 유저면 200 코드를 반환
        return new ResponseEntity<>(map,HttpStatus.OK);
    }catch(Exception e) {
        map=new HashMap<>();
        map.clear();
        map.put("message",req.toString());

        // 에러가 발생하면은 404코드를 반환
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
    }


}
