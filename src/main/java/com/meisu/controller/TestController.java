package com.meisu.controller;

import com.meisu.beans.RB;
import com.meisu.beans.ResultBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class TestController {

    @GetMapping("test")
    public ResultBean<String> test() {
        return new ResultBean<>().setCode(1).setMsg("test").setData("test");
    }

    @PostMapping("user/login")
    public ResultBean<String> login(User user) {
        System.out.println(user);
        return new ResultBean<>().setCode(RB.SUCCESS).setData(new User("wade", "12345"));
    }
}

@Data
@AllArgsConstructor
class User {
    private String username;
    private String password;
}
