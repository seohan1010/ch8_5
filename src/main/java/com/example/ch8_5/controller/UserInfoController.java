package com.example.ch8_5.controller;


import com.example.ch8_5.to.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserInfoController {


    // 유저를 등록하는 로직
    @RequestMapping(value="/user",method= RequestMethod.POST)
    public void registerUser(@RequestBody UserDto userDto){



    }

    // 유저의 정보를 수정하는 로직
    @RequestMapping(value="/user",method=RequestMethod.PUT)
    public ResponseEntity<String> modifyUser(@RequestBody UserDto userDto){
        System.out.println("userDto = " + userDto);
        return new ResponseEntity<>("good", HttpStatus.OK);
    }



}
