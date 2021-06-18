package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user u where u.phone=#{phone}")
    User getByPhone(String phone);

    @Select("select * from user u where u.role=1")
    List<User> findAll();

    @Select("delete from user u where u.phone=#{phone}")
    void   deleteByPhone(String phone);

    @Update("update user  set name = #{name}  where phone=#{phone}")
    void updateUser(User user);
}