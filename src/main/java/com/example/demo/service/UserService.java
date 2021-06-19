package com.example.demo.service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public com.example.demo.domain.User getUserByPhone(String phone){
       com.example.demo.domain.User user = (com.example.demo.domain.User) userMapper.getByPhone(phone);
        return user;
    }

    public void add(com.example.demo.domain.User user){
        userMapper.insert(user);
    }

    public int  removeById(Long id) {
        return userMapper.deleteById(id);
    }


    public void removeByPhone(String phone) {
         userMapper.deleteByPhone(phone);
    }

    public void update(User user){
        userMapper.updateUser(user);
    }



    public User selectById(Long id) {
        return (com.example.demo.domain.User) userMapper.selectById(id);
    }


    public List<User> findAll(){
        return userMapper.findAll();
    }

    public UserDTO findUserDTO(long uid) {
        return userMapper.findUserDTO(uid);
    }

}
