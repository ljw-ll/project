package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserByPhone(String phone){
       User user = (User) userMapper.getByPhone(phone);
        return user;
    }

    public void insert(User user){
        userMapper.insert((com.example.demo.domain.User) user);
    }


    public void delete(Long id) {
        userMapper.deleteById(id);
    }

    public User selectById(Long id) {
        return (User) userMapper.selectById(id);
    }



}
