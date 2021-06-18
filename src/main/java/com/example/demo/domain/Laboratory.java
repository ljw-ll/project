package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("laboratory")
public class Laboratory {
    private Long id;

    private Integer classnum;

    private Integer mnum;

    private String message;

    private Integer laborcheck;
}