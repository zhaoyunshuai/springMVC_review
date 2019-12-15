package cn.zs.response.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.OK;

@Controller
@RequestMapping("response")
public class ResponseController {
    /**
     * 当返回值类型为String时，返回的字符串就是视图名称
     * @return
     */
    @RequestMapping("string")
    public String Test01(){
        System.out.println("请求进来了..1211211234");
        String hello ="requestString";
        return hello;
    }
    @RequestMapping("void")
    @ResponseStatus(value = OK)
    public void Test02(){
        System.out.println("返回值类型为void时，必须返回一个Http状态码");
    }
}
