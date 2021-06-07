package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("course")
public class Course {
    private Integer id;

    private String cname;

    private Integer ctime;

    private Integer cnum;
}