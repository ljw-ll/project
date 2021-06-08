package com.example.demo.controller.interceptor;

import com.example.demo.common.EncryptComponent;
import com.example.demo.controller.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@Controller
public class LoginInterceptor implements HandlerInterceptor {

   @Autowired
   private EncryptComponent encryptComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if(token==null){
            throw new MyException(401,"未登录");
        }
        Map<String,Object> result =encryptComponent.decrypt(token);
        request.setAttribute("role",result.get("role"));
        return true;
    }
}
