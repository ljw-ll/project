package com.example.demo.DTO;

import com.example.demo.domain.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private  long id;
    private  String name;
    List<Course> courses;
}
