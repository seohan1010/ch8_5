package com.example.ch8_5.mapper;


import com.example.ch8_5.to.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {


    @Autowired
    UserMapper userMapper;

    // test 어노테이션은 junit 클래스에서 가지고 오는것이 아닌
    // jupiter의 어노테이션을 가지고 와야 한다.
    @Test
    public void Test() {
        System.out.println("userMapper = " + userMapper);
    }


    @Test
    @DisplayName("insert user test")
    public void insertTest() {

        String email = "ccc@ccc.com";
        String name = "adsf3";
        String password = "11111111";
        String phoneNumber = "010-1234-1234";

        UserDto user = new UserDto();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);


        try {
            userMapper.insertUser(user);
            UserDto user2 = userMapper.selectUser(email);
            assertNotNull(user2);
            System.out.println("<<<<<<<<<< user2 = " + user2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    @DisplayName("this is for me")
    public void selectTest() {
        String email = "aaa@aaa.com";

        try {
            UserDto user = userMapper.selectUser(email);
            System.out.println("<<<<<<<<< user = " + user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void updateTest() {

        String email = "test";
        String name = "modified test";
        String password = "test modified";
        String phoneNumber = "test modified";

        UserDto user = new UserDto();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);

        try {
            userMapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Test
    @DisplayName("deleteUser Test")
    public void deleteUser() {

        String email = "bbb@bbb.com";

        try {
            userMapper.deleteUser(email);
            UserDto userDto = userMapper.selectUser(email);
            assertNull(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}