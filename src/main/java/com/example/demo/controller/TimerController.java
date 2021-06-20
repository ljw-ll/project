package com.example.demo.controller;

import com.example.demo.common.ResultVo;
import com.example.demo.domain.Timer;
import com.example.demo.domain.User;
import com.example.demo.service.TimerService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/timer")
public class TimerController {

    @Autowired
    private TimerService timerService;

    @Autowired
    private UserService userService;


    @RequestMapping("/update")
    public ResultVo update(@RequestBody Timer timer, HttpServletResponse response){
       /* Long id = timer.getId();
        User u= (User) userService.selectById(id);
        if(u==null){
            return ResultVo.error(400,"修改失败");
        }*/
        timer.setTcheck(1);
        timerService.updateTimer(timer);
       List<User> list = userService.findAll();
        return ResultVo.success("更新成功", Map.of("list_user",list));
    }


}
