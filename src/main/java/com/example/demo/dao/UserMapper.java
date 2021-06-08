package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user u where u.phone=#{phone}")
    User getByPhone(String phone);


}