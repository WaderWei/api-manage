package com.meisu.test;

import com.meisu.entity.sqlserver.Role;
import com.meisu.mapper.sqlserver.RoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void test1(){
        List<Role> roles = roleMapper.selectList(null);
        System.out.println(roles);
    }
}
