package com.example.ch8_5.service;

import com.example.ch8_5.to.UserDto;

public interface UserService {
    public abstract UserDto retrieveUser(String email) throws Exception;
}
