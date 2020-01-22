package com.meisu.controller;

import com.meisu.beans.RB;
import com.meisu.beans.ResultBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        return new ResultBean<>().setCode(RB.SUCCESS).setData("admin-token");
    }

    @GetMapping("user/info")
    public ResultBean<String> info() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("admin");
        return new ResultBean<>().setCode(RB.SUCCESS).setData(new User("wade", "123",
                strings, "I am a super administrator", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"));
    }

    @PostMapping("test1")
    public ResultBean<String> test1(@RequestParam("id") Long id) {
        return new ResultBean<>().setCode(RB.SUCCESS).setData(id.toString());
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private String password;
    private List<String> roles;
    private String introduction;
    private String avatar;
}
