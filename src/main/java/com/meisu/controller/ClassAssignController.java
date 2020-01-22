package com.meisu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.meisu.beans.RB;
import com.meisu.beans.ResultBean;
import com.meisu.entity.sqlserver.ClassAssign;
import com.meisu.entity.sqlserver.ClassUserVo;
import com.meisu.mapper.sqlserver.ClassAssignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("classAssign")
public class ClassAssignController {
    @Autowired
    private ClassAssignMapper classAssignMapper;

    @GetMapping("{classId}")
    public ResultBean<ClassUserVo> getClassUsers(@PathVariable("classId") Long classId) {
        return new ResultBean<>().setCode(RB.SUCCESS).setData(classAssignMapper.getClassUsersById(classId));
    }

    @DeleteMapping("delete")
    public ResultBean<Integer> deleteClassUser(Long classId, Long userId) {
        int delete = classAssignMapper.delete(new QueryWrapper<ClassAssign>().lambda().eq(ClassAssign::getClassId, classId).eq(ClassAssign::getUserId, userId));
        return new ResultBean<>().setCode(RB.SUCCESS).setData(delete);
    }
}
