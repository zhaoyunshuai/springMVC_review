package cn.zs.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("show")
    public ModelAndView test01() {
        System.out.println("用户请求进来了");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg", "RequestMapping的使用");
        return mv;
    }
}
