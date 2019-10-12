package com.meisu.mapper.mysql;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meisu.entity.mysql.User;

/**
 * @author Administrator
 */
@DS("mysql")
public interface UserMapper extends BaseMapper<User> {

}
