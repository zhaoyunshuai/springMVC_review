package cn.zs.requestParam.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("hello")
public class requestParamController {
@RequestMapping("test01/{id}/{name}")
    public ModelAndView text01(@PathVariable("id") String id, @PathVariable("name") String name){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg","占位符映射：id"+id+"name:"+name);
        return mv;
    }
@RequestMapping("test02")
    public String test02(Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session){

    model.addAttribute("msg","接收servlet常用的内置对象：session:"+session+"--request:"+request+"--response"+response);
        return "hello01";
    }
}
