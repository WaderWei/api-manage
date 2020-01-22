package com.meisu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meisu.beans.RB;
import com.meisu.beans.ResultBean;
import com.meisu.entity.sqlserver.ClassInfo;
import com.meisu.mapper.sqlserver.ClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("classInfo")
public class ClassInfoController {

    @Autowired
    private ClassInfoMapper classInfoMapper;

    @GetMapping("get/{id}")
    public ResultBean<List<ClassInfo>> getClassInfo(@PathVariable("id") Long id) {
        LambdaQueryWrapper<ClassInfo> queryWrapper = null;
        if (id != 0) {
            queryWrapper = new QueryWrapper<ClassInfo>().lambda().eq(ClassInfo::getClassId, id);
        }
        List<ClassInfo> classInfos = classInfoMapper.selectList(queryWrapper);
        return new ResultBean<>().setCode(RB.SUCCESS).setData(classInfos);
    }

    @PostMapping("updateClassInfo")
    public ResultBean<Integer> updateClassInfo(@RequestParam("id") Long id) {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassId(id).setClassTestStatus(0);
        int result = classInfoMapper.updateById(classInfo);
        return new ResultBean<>().setCode(RB.SUCCESS).setData(result);
    }
}
