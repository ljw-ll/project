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

    private Integer classnum;   // 教室号

    private Integer mnum;    //机器数量

    private String message;  // 机器配置

    private Integer check;
}