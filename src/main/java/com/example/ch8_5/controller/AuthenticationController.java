package com.example.ch8_5.controller;


import com.example.ch8_5.mapper.UserMapper;
import com.example.ch8_5.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public ResponseEntity<HttpStatus> login(@RequestBody UserDto userDto) {
        try {

            //유효한 유저가 아니면 404코드를 반환
            if (!isValid(userDto))
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            // 유효한 유저면 200 코드를 반환
            return new ResponseEntity<>(HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            // 에러가 발생하면은 404코드를 반환
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // 유저의 정보가 유효한지 확인하는 로직
    private boolean isValid(UserDto user) {

        try {
            UserDto user2 = userMapper.selectUser(user.getEmail());
            return user2 != null && user.getPassword().equals(user2.getPassword());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
