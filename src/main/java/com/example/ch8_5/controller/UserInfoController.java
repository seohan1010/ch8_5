package com.example.ch8_5.controller;


import com.example.ch8_5.to.UserDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserInfoController {



    @RequestMapping(value="/user",method= RequestMethod.POST)
    public void registerUser(@RequestBody UserDto userDto){



    }



}
