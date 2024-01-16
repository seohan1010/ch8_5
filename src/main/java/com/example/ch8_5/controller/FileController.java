package com.example.ch8_5.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    @Value("@{spring.servlet.multipart.location}")
    String filepath;


}
