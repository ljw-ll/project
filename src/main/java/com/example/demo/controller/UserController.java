package com.example.demo.controller;

import com.example.demo.common.ResultVo;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/findAll")
    public ResultVo findAll(HttpServletResponse response){
        List<User> list = userService.findAll();
        return ResultVo.success(Map.of("list_user",list));
    }

    @RequestMapping("/del/{phone}")
    public ResultVo login(@PathVariable String phone, HttpServletResponse response){
       // System.out.println(phone);
          userService.removeByPhone(phone);
            return ResultVo.success("删除成功");
    }

    @PostMapping("/add")
    public ResultVo add(@RequestBody User user, HttpServletResponse response){
        String phone = user.getPhone();
        User u= (User) userService.getUserByPhone(user.getPhone());
        if(u!=null){
            return ResultVo.error(400,"添加失败");
        }
        userService.add(user);
        return  ResultVo.success("添加成功");
    }


    @RequestMapping("/update")
    public ResultVo update(@RequestBody User user, HttpServletResponse response){
        String phone = user.getPhone();
        User u= (User) userService.getUserByPhone(user.getPhone());
        if(u==null){
            return ResultVo.error(400,"修改失败");
        }
        userService.update(user);
        return  ResultVo.success("添加成功");
    }




}
