package cn.zs.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@org.springframework.stereotype.Controller
public class Hello2Controller implements Controller {
    @RequestMapping("/show.do")//此处可以写成show也可以写成show.do，都会被HandlerAdapter找到。
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("前端请求进来了.........");
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","这是一个基于springMVC注解的程序");

        return mv;
    }


}
