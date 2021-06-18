package com.example.demo.controller;

import com.example.demo.common.ResultVo;
import com.example.demo.domain.Laboratory;
import com.example.demo.domain.User;
import com.example.demo.service.LaboratoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/laboratory")
public class LaboratoryController {
    @Autowired
    private LaboratoryService laboratoryService;

    @RequestMapping("/findAll")
    public ResultVo findAll(HttpServletResponse response){
        List<Laboratory> list = laboratoryService.findAll();
        return ResultVo.success(Map.of("list_laboratory",list));
    }


    @RequestMapping("/del/{id}")
    public ResultVo login(@PathVariable long id, HttpServletResponse response){
        // System.out.println(phone);
        Laboratory laboratory = laboratoryService.selectById(id);
        if(laboratory==null){
           return  ResultVo.error(404,"已删除,不可重复删除");
        }

        laboratoryService.removeById(id);
        List<Laboratory> list = laboratoryService.findAll();
        return ResultVo.success("删除成功",Map.of("list_laboratory",list));
    }


    @PostMapping("/add")
    public ResultVo add(@RequestBody Laboratory laboratory, HttpServletResponse response){
        Integer classnum = laboratory.getClassnum();
        Laboratory labor = laboratoryService.selectByClassnum(classnum);
        log.debug("{}",labor.getClassnum());

        if(labor!=null){
            return ResultVo.error(400,"添加失败");
        }
        laboratoryService.add(laboratory);
        List<Laboratory> list = laboratoryService.findAll();
        return ResultVo.success("添加成功",Map.of("list_laboratory",list));
    }


    @RequestMapping("/update")
    public ResultVo update(@RequestBody Laboratory laboratory, HttpServletResponse response){
        Long id = laboratory.getId();
        Laboratory labor = laboratoryService.selectById(id);
        if(labor==null){
           // return ResultVo.error(400,"修改失败");
            // 保存新的
            laboratoryService.add(laboratory);
            List<Laboratory> list = laboratoryService.findAll();
            return ResultVo.success("添加成功",Map.of("list_laboratory",list));
        }
        laboratoryService.update(laboratory);
        List<Laboratory> list = laboratoryService.findAll();
        return ResultVo.success("更新成功",Map.of("list_laboratory",list));
    }



}
