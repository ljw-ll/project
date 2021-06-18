package com.example.demo.service;

import com.example.demo.dao.LaboratoryMapper;
import com.example.demo.domain.Laboratory;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LaboratoryService {
    @Autowired
    private LaboratoryMapper laboratoryMapper;

    public List<Laboratory> findAll(){
        return laboratoryMapper.findAll();
    }

    public Laboratory selectById(Long id) {
        return laboratoryMapper.selectById(id);
    }
    public Laboratory selectByClassnum(Integer classnum) {
        return laboratoryMapper.getByLaboraty(classnum);
    }

    public void add(Laboratory laboratory){
        laboratoryMapper.insert(laboratory);
    }
    public  int removeById(long id){
        return laboratoryMapper.deleteById(id);
    }
    public void update(Laboratory laboratory){
        laboratoryMapper.updateUser(laboratory);
    }



}
