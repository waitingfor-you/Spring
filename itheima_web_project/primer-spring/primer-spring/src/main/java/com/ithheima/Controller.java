package com.ithheima;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class Controller {
    // 数组参数测试
    // 如果是选择用post，需要在body中写入参数
    @RequestMapping("/arrayTest")
    public String arrayTest(String[] hobby)
    {
        System.out.println(Arrays.toString(hobby));
        return "ok~";
    }

    @RequestMapping("/normalParamTest1")
    public String normalParamTest1(HttpServletRequest request)
    // public String normalParamTest1(String name, int age)  可以不用再进行参数转换了
    //如果参数不对应的话对应的参数会自动设置为null

    //public String normalParamTest1(@RequestParam(name="name") String username, integer age)
    //@RequestParam(name="name")后面的参数会自动映射到name参数中
    {
        // 普通参数测试1  如果是post还是在Body中选择
        // http://localhost:8080/normalParamTest1?name=Tom&age=18
        String name = request.getParameter("name");
        //
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);
        System.out.println(name+":"+age);
        return "ok~";
    }
}


