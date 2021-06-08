package com.example.demo.controller;

import com.example.demo.common.EncryptComponent;
import com.example.demo.common.ResultVo;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
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
       User u= (User) userService.getUserByPhone(user.getPhone());
       if(u==null||encoder.matches(u.getPassword(),user.getPassword())){
           return ResultVo.error(401,"账号或密码错误!");
       }
        String result = encryptComponent.encrypt(Map.of("uid", u.getId(), "role", u.getRole(), "username", u.getUsername()));
         response.setHeader("token",result);
         return ResultVo.success(Map.of("role",u.getRole(),"username",u.getUsername()));

    }
}
