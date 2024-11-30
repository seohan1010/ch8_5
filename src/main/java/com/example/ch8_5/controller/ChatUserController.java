package com.example.ch8_5.controller;

import com.example.ch8_5.to.UserChatMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000", "*"})
@RestController
@RequestMapping(value = "/chatuser")
public class ChatUserController {

    Map<String,Object> map = null;


    @RequestMapping(value="/retrieve_msg", method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> retrieveUserData (@RequestBody UserChatMsg ucMsg){
            map = new HashMap<>();


        try {
            map.clear();
            map.put("message",ucMsg.toString());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception e){
            map.clear();
            map.put("message","error");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);

        }

    }

}
