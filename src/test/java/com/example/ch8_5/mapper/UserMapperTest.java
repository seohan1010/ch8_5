package com.example.ch8_5.mapper;

import com.example.ch8_5.to.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class UserMapperTest {


    @Autowired
    UserMapper userMapper;



    @Test
    public void test(){

        System.out.println("<<<<<<<<< userMapper = " + userMapper);
    }


    @Test
    public void selectUserTest()throws Exception{

        String email ="aaa@aaa.com";

       UserDto user= userMapper.selectUser(email);
        assertNotNull(user);
        System.out.println("<<<<<<<<< user = " + user);
    }

}