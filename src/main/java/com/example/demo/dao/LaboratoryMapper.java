package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.Laboratory;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper

public interface LaboratoryMapper extends BaseMapper<Laboratory> {

    @Select("select * from laboratory ")
    List<Laboratory> findAll();

    @Select("select * from laboratory la where la.classnum=#{classnum}")
    Laboratory getByLaboraty(Integer classnum);


    /*
    private Long id;
    private Integer classnum;
    private Integer mnum;
    private String message;
    private Integer check;
     */
    @Update("update laboratory  set classnum = #{classnum} ,  mnum=#{mnum},laborcheck=#{laborcheck }  where id=#{id}")
    void updateUser(Laboratory laboratory);

}