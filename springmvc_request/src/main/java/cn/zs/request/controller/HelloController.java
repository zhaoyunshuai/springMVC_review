package cn.zs.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class HelloController {
    //标准URL映射
    @RequestMapping("show")
    public ModelAndView test01() {
        System.out.println("用户请求进来了");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg", "RequestMapping的使用");
        return mv;
    }

    /**
     * ant 风格的映射，?表示可以匹配任意单个字符
     *
     * @return
     */
    @RequestMapping("show2?")
    public ModelAndView test02() {
        System.out.println("用户请求进来了");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg", "ant风格的映射：?的使用");
        return mv;
    }
    /**
     * ant 风格的映射，*表示可以匹配0个或多个字符
     *
     * @return
     */
    @RequestMapping("show3*")
    public ModelAndView test03() {
        System.out.println("用户请求进来了");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg", "ant风格的映射：*的使用");
        return mv;
    } /**
     * ant 风格的映射，**表示可以匹配0个或多个路径。
     *
     * @return
     */
    @RequestMapping("show4/**")
    public ModelAndView test04() {
        System.out.println("用户请求进来了");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg", "ant风格的映射：**的使用");
        return mv;
    }
}
