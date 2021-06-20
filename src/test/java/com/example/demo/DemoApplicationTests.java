package com.example.demo;

import com.example.demo.DTO.CourseDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.dao.CourseMapper;
import com.example.demo.dao.TimerMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.Course;
import com.example.demo.domain.Laboratory;
import com.example.demo.domain.Timer;
import com.example.demo.domain.User;
import com.example.demo.service.CourseService;
import com.example.demo.service.LaboratoryService;
import com.example.demo.service.UserService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Predicate;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private  UserService userService;
    @Autowired
    private LaboratoryService laboratoryService;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseService courseService;
    @Test
    void test_findAll(){
       // List<User> list=userService.findAll();
        User u = User.builder()
                .password("123456")
                .name("ljw" )
                .role(0).phone("13835210372").build();
        userService.add(u);
       // log.debug("{}",list);
    }

    @Test
    void  test_insertUser(){
        for(int i=3;i<=9;i++) {
            User u = User.builder()
                    .password("123456")
                    .name("ljw" + i)
                    .role(1).phone("1383521037" + i).build();
            userService.add(u);
        }
    }

    /*
     private Long id;
    private Integer classnum;
    private Integer mnum;
    private String message;
    private Integer check;
     */
    @Test
    void test_insertLaboratory(){
      for(int i=1;i<=9;i++) {
          Laboratory labor = Laboratory.builder()
                  .classnum(900+(Integer)i)
                  .mnum(40 + i * 5)
                  .message("win10 i7-8750H CPU @2.20GHz  x64")
                  .laborcheck(0)
                  .build();
          laboratoryService.add(labor);

      }
    }

    @Test
    void test_insertCourse(){
        for(int i=1;i<=5;i++) {
            Course course = Course.builder()
                    .cname("Java" + i)
                    .cnum(10 + i * 10)
                    .ctime(20 + i * 5)
                    .userid(1405802226400473090L)
                    .build();
            courseMapper.insert(course);
        }
    }

    @Autowired
    private  UserMapper userMapper;

    @Test
    void Test_select(){
       // UserDTO userDTO = userMapper.findUserDTO(1405802226400473090L);
        UserDTO userDTO = userService.findUserDTO(1405802226400473090L);
        log.debug("{}/{}",userDTO.getName(),userDTO.getId());
        for (Course a : userDTO.getCourses()) {
            log.debug("{}/{}",a.getCname() ,a.getId());
        }
    }

    @Autowired
    private TimerMapper timerMapper;

    @Test
    void Test__insertTimer(){
       for (int i=5;i<19;i++) {
           for (int j = 1;j<=4;j++){
               Timer timer = Timer.builder()
                       .classnum(901)
                       .tnum(j)
                       .tcheck(0)
                       .tweek(i)
                       .build();
               timerMapper.insert(timer);
           }
       }

    }


    @Test
    void Test_selectCouserDTO(){
        // UserDTO userDTO = userMapper.findUserDTO(1405802226400473090L);
        CourseDTO courseDTO = courseService.findCourseDTO(1405883279685255169L);
        log.debug("{}/{}",courseDTO.getId(),courseDTO.getId());
        for (Timer t : courseDTO.getTimers()) {
            log.debug("{}/{}",t.getClassnum() ,t.getTcheck());
        }
    }

}
