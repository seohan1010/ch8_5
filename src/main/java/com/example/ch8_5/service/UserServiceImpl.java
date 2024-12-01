package com.example.ch8_5.service;

import com.example.ch8_5.mapper.UserMapper;
import com.example.ch8_5.to.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void registerUser(UserDto userDto) throws Exception {
        userMapper.insertUser(userDto);
    }

    @Override
    public UserDto retrieveUser(String email)throws Exception{
        return userMapper.selectUser(email);
    }

    @Override
    public void modifyUser(UserDto userDto) throws Exception {
        userMapper.updateUser(userDto);

    }

    @Override
    public void removeUser(String email) throws Exception {
        userMapper.deleteUser(email);
    }


}
