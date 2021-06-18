package com.example.demo.common;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data  // 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
@Builder
public class ResultVo {
    private int code;
    private String message;
    private Map<String,Object> data;

   public static ResultVo success(Map<String,Object> data){
       return ResultVo.builder().code(200).data(data).build();
   }

    public static ResultVo success(String msg){
        return ResultVo.builder().code(200).message(msg).build();
    }

   public static ResultVo error(int code,String message){
       return ResultVo.builder().code(code).message(message).build();
   }
}
