package com.example.ch8_5.service;

import com.example.ch8_5.to.UserDto;

public interface UserService {
    public abstract void registerUser(UserDto userDto)throws Exception;
    public abstract UserDto retrieveUser(String email) throws Exception;
    public abstract void modifyUser(UserDto userDto)throws Exception;
    public abstract void removeUser(String email)throws Exception;
}
