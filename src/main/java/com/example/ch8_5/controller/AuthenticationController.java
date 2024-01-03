package com.example.ch8_5.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000", "*"})
@RestController
public class AuthenticationController {
}
