package com.example.ch8_5.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String testMethod() {
        return "Hello";
    }


}
