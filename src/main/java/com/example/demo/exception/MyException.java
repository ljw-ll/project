package com.example.demo.exception;

import lombok.*;

/**
 * 声明自定义异常类
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException {
    private int code;

    public MyException(int code,String message){
        super(message);
        this.code=code;
    }

}
