package cn.zs.contoller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController  implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("前端请求进来了.........");
        ModelAndView mv= new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","我是SpringMVC的第一个程序");

        return mv;
    }


}
