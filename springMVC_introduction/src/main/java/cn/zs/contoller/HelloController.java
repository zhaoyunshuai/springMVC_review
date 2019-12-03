package cn.zs.contoller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@org.springframework.stereotype.Controller
public class HelloController implements Controller {
@RequestMapping("hello.do")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("springMVC请求进来了");
        ModelAndView view = new ModelAndView();
        view.addObject("msg","这是我的第一个SpringMVC程序");
        view.setViewName("WEB-INF/jsp/hello.jsp");
        return view;
    }
}
