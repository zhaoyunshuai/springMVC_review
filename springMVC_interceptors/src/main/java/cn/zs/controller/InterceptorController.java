package cn.zs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("myInterceptor")
public class InterceptorController {
    @RequestMapping("test01")
    public String test01(Model model) {
        model.addAttribute("msg", "在我执行之前会有拦截器去拦截请求的哦........");
        return "interceptorjsp";
    }
}
