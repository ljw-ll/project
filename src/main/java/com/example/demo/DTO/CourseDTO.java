package com.example.demo.DTO;

import com.example.demo.domain.Course;
import com.example.demo.domain.Timer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CourseDTO {
    private  long id;
    private  String cname;
    List<Timer> timers;
}
