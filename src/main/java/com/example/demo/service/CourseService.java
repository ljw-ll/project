package com.example.demo.service;

import com.example.demo.DTO.CourseDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.dao.CourseMapper;
import com.example.demo.dao.LaboratoryMapper;
import com.example.demo.domain.Course;
import com.example.demo.domain.Laboratory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseService {



    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findAll(){
        return courseMapper.findAll();
    }

    public Course selectById(Long id) {
        return courseMapper.selectById(id);
    }

    public Course selectByCname(String cname,long userid) {
        return courseMapper.getByCname(cname,userid);
    }

    public void add(Course course){
       courseMapper.insert(course);
    }
    public  int removeById(long id){
        return courseMapper.deleteById(id);
    }
    public void update(Course course){ courseMapper.updateCourse(course);
    }


    public CourseDTO findCourseDTO(long cid) {
        return courseMapper.findCourseDTO(cid);
    }
}
