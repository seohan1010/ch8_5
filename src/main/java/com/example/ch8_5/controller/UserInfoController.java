package com.example.ch8_5.controller;


import com.example.ch8_5.service.UserService;
import com.example.ch8_5.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    UserService userService;

    @Autowired
    public UserInfoController(UserService userService) {
        this.userService = userService;
    }

    // 유저를 등록하는 로직
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> registerUser(@RequestBody UserDto userDto) {

        try {
            userService.registerUser(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    // 유저의 정보를 수정하는 로직
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> modifyUser(@RequestBody UserDto userDto) {

        try {
            userService.modifyUser(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value="/user",method=RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> removeUser(@RequestBody UserDto userDto){

        String email = userDto.getEmail();

        try {
            userService.removeUser(email);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



}
