package com.example.ch8_5.mapper;


import com.example.ch8_5.to.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    public abstract UserDto selectUser(String email)throws Exception;



}
