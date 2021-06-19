package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.domain.Course;
import com.example.demo.domain.Laboratory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseMapper extends BaseMapper<Course> {


    @Select("select * from  course")
    List<Course> findAll();

        @Select("select * from course c where c.cname=#{cname} and c.userid=#{userid}")
        Course getByCname(String cname,long userid);

    /*
   private Long id;
   private String cname;
   private Integer ctime;
   private Integer cnum;
   private Long userid;
   */
    @Update("update course c set cname = #{c.cname} , c.ctime=#{ctime} ,c.cnum=#{cnum}, c.userid=#{ userid }  where id=#{id}")
    void updateCourse(Course course);


}
