package com.example.demo.controller;

import com.example.demo.common.EncryptComponent;
import com.example.demo.common.ResultVo;
import com.example.demo.exception.MyException;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public ResultVo login(@RequestBody User user, HttpServletResponse response){
        System.out.println(user.getPhone());
        System.out.println(user.getPassword());
       User u= (User) userService.getUserByPhone(user.getPhone());

       if(u==null||encoder.matches(u.getPassword(),user.getPassword())){
        //if(u==null||u.getPassword()!=user.getPassword()){
            System.out.println(11111111);
           return ResultVo.error(401,"账号或密码错误!");
       }
        String result = encryptComponent.encrypt(Map.of("uid", u.getId(), "role", u.getRole(), "name", u.getName()));
         response.setHeader("token",result);
         response.setHeader("role",u.getRole().toString());
         log.debug("{}",result);
         return ResultVo.success(Map.of("role",u.getRole(),"name",u.getName(),"phone",u.getPhone(),"id",u.getId()));
    }

    @RequestMapping("/register")
    public ResultVo register(@RequestBody User user, HttpServletResponse response){
        User u= userService.getUserByPhone(user.getPhone());
        if(u!=null){
            throw new MyException(-1,"用户手机号已注册");
        }

        userService.add(user);

        return ResultVo.success(Map.of("message","注册成功"));
    }


}
