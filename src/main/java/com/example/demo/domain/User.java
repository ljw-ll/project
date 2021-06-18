package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("user")
public class User {
    private Long id;

    private String name;

    private String password;

    private String phone;

    private Integer role;
}