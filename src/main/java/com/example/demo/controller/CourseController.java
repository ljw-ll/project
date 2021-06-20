package com.example.demo.controller;

import com.example.demo.DTO.CourseDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.common.ResultVo;
import com.example.demo.dao.CourseMapper;
import com.example.demo.domain.Course;
import com.example.demo.domain.Laboratory;
import com.example.demo.domain.User;
import com.example.demo.service.CourseService;
import com.example.demo.service.LaboratoryService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

   @Autowired
   private  UserService userService;


   /* @RequestMapping("/findAll")
    public ResultVo findAll(HttpServletResponse response){
        List<Laboratory> list = laboratoryService.findAll();
        return ResultVo.success(Map.of("list_laboratory",list));
    }*/


    @RequestMapping("/del/{id}")
    public ResultVo login(@PathVariable long id, HttpServletResponse response){
        // System.out.println(phone);

        Course course = courseService.selectById(id);
        if(course==null){
            return  ResultVo.error(404,"已删除,不可重复删除");
        }

        courseService.removeById(id);

        UserDTO list_UserDTO = userService.findUserDTO(course.getUserid());
        return ResultVo.success("查找成功",Map.of("list_UserDTO",list_UserDTO));
    }


    @PostMapping("/add")
    public ResultVo add(@RequestBody Course course, HttpServletResponse response){
        log.debug("add_course");
        /*String cname = course.getCname();
        Long userid = course.getUserid();

        Course course1 = courseService.selectByCname(cname, userid);
        log.debug("{}",course1.getCname());

        if(course!=null){
            return ResultVo.error(400,"添加失败");
        }*/

        courseService.add(course);
        UserDTO list_UserDTO = userService.findUserDTO(course.getUserid());
        return ResultVo.success("查找成功",Map.of("list_UserDTO",list_UserDTO));
    }


    @RequestMapping("/update")
    public ResultVo update(@RequestBody Course course, HttpServletResponse response){
        Long id = course.getId();
        Course course1 = courseService.selectById(id);
        if(course1==null){
            // return ResultVo.error(400,"修改失败");
            // 保存新的
            courseService.add(course);
            UserDTO list_UserDTO = userService.findUserDTO(course.getUserid());
            return ResultVo.success("查找成功",Map.of("list_UserDTO",list_UserDTO));
        }
        courseService.update(course);
        UserDTO list_UserDTO = userService.findUserDTO(course.getUserid());
        return ResultVo.success("查找成功",Map.of("list_UserDTO",list_UserDTO));
    }


    @RequestMapping("/findCourseDTO/{id}")
    public ResultVo findDTO(@PathVariable long id, HttpServletResponse response){

        Course course = courseService.selectById(id);
        if(course==null){
            return ResultVo.error(403,"资源未找到");
        }

        CourseDTO list_CourseDTO = courseService.findCourseDTO(id);
        return ResultVo.success("查找成功",Map.of("list_CourseDTO",list_CourseDTO));
    }

}
