package com.meisu.mapper.sqlserver;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meisu.entity.sqlserver.Role;

/**
 * @author Administrator
 */
@DS("sqlserver")
public interface RoleMapper extends BaseMapper<Role> {
}
