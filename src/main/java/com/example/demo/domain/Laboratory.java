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
    private Integer id;

    private Integer mnum;

    private String message;
}