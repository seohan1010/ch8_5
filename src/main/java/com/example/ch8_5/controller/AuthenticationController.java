package com.example.ch8_5.controller;


import com.example.ch8_5.to.UserDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000", "*"})
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @RequestMapping(value = "/logout")
    public void logOut() {
    }

    @RequestMapping(value = "/login")
    public void login(@RequestBody UserDto userDto) {

    }


}
