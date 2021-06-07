package com.example.demo.common;

import com.example.demo.controller.exception.MyException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class EncryptComponent {
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${my.secretKey}")
    private  String secretKey;
    @Value("${my.salt}")
    private  String salt;
    @Autowired
    private TextEncryptor encryptor;

    /**
     * 直接基于密钥/盐值创建单例TextEncryptor对象。避免反复创建
     * 在通过Autowired 注入
     * @return
     */
    @Bean
    public TextEncryptor getTextEncryptor(){
        return Encryptors.text(secretKey,salt);
    }

    public  String encrypt(Map<String,Object> payload){
        try {
            // writeValueAsString  将对象 转为 字符串
            String json = objectMapper.writeValueAsString(payload);
            return encryptor.encrypt(json);
        } catch (JsonProcessingException e) {
            throw new MyException(500,"服务器错误");
        }

    }

    /**
     * 无法验证/解密/反序列化，说明数据被篡改，判定无权限
     * @param auth
     * @return
     */
    public Map<String,Object> decrypt(String auth){

        try {
            String json = encryptor.decrypt(auth);
            //字符串转Map 集合
            return  objectMapper.readValue(json,Map.class);
        } catch (JsonProcessingException e) {
            throw  new MyException(403,"无权限");
        }
    }






}
