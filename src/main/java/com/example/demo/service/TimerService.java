package com.example.demo.service;

import com.example.demo.dao.TimerMapper;
import com.example.demo.domain.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TimerService {
    @Autowired
    private TimerMapper timerMapper;

    public void updateTimer(Timer timer){
        timerMapper.updateTimer(timer);
    }
}
