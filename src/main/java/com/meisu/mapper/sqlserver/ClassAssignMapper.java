package com.meisu.mapper.sqlserver;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meisu.entity.sqlserver.ClassAssign;
import com.meisu.entity.sqlserver.ClassUserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 */
@DS("sqlserver")
@Component
public interface ClassAssignMapper extends BaseMapper<ClassAssign> {
    /**
     * 根据classID查询
     * @param classId
     * @return
     */
    @Select("SELECT hr.id,hr.lastname,ca.study_status,ca.class_id from HrmResource hr join MS_PX_CLASS_ASSIGN ca on hr.id = ca.user_id where class_id = #{classId}")
    List<ClassUserVo> getClassUsersById(@Param("classId") Long classId);
}
