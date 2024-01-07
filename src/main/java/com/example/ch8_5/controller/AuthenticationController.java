package com.example.ch8_5.controller;


import com.example.ch8_5.mapper.UserMapper;
import com.example.ch8_5.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000", "*"})
@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    UserMapper userMapper;

    @Autowired
    public AuthenticationController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/logout")
    public ResponseEntity<HttpStatus> logOut() {



        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/login")
    public ResponseEntity<HttpStatus> login(@RequestBody UserDto userDto) {
        try {

            //유효한 유저가 아니면 404코드를 반환
            if (!isValid(userDto))
                return ResponseEntity.status(404).build();
            // 유효한 유저면 200 코드를 반환
            return ResponseEntity.status(200).build();


        } catch (Exception e) {
            e.printStackTrace();
            // 에러가 발생하면은 404코드를 반환
            return ResponseEntity.badRequest().build();
        }
    }

    private boolean isValid(UserDto user) {

        try {
            UserDto user2 = userMapper.selectUser(user.getEmail());
            if (user2 != null && user.getPassword().equals(user2.getPassword()))
                return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
