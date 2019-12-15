package cn.zs.requestParam.controller;

import cn.zs.User;
import cn.zs.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("hello")
public class requestParamController {
    @RequestMapping("test01/{id}/{name}")
    public ModelAndView text01(@PathVariable("id") String id, @PathVariable("name") String name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg", "占位符映射：id" + id + "name:" + name);
        return mv;
    }

    @RequestMapping("test02")
    public String test02(Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session) {

        model.addAttribute("msg", "接收servlet常用的内置对象：session:" + session + "--request:" + request + "--response" + response);
        return "hello01";
    }

    @RequestMapping("test03")
    public String Test03(Model model, @RequestParam(value = "name", defaultValue = "lisi") String name) {
        model.addAttribute("msg", "接收普通类型的参数：name" + name);
        return "requestString";
    }

    @RequestMapping("test04")
    public String test23(Model model, @RequestParam("name") String name,
                         @RequestParam("age") Integer age,
                         @RequestParam("isMarry") Boolean isMarry,
                         @RequestParam("income") Float income,
                         @RequestParam("interests") String[] interests) {
        System.out.println(name);
        System.out.println(age);
        System.out.println(isMarry);
        System.out.println(income);
        System.out.println(Arrays.toString(interests));
        return "hello01";
    }

    @RequestMapping("test05")
    public ModelAndView test04(User user, @RequestParam(value = "name") String name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg", user + ":::::" + name);
        return mv;
    }

    @RequestMapping("test005")
    public ModelAndView Test05(@RequestParam(value = "ids") List<Integer> ids) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello01");
        mv.addObject("msg", ids);
        return mv;
    }

    @RequestMapping(value = "show26")
    public String Test06(Model model, UserList users) {
        model.addAttribute("msg", users);
        return "hello01";

    }

    @RequestMapping("zs")
    @ResponseBody
    public List<User> Test07(Model model) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(18 + i);
            user.setIncome(100f);
            if (i / 2 == 0) {
                user.setIsMarry(true);
            } else {
                user.setIsMarry(false);
            }
            users.add(user);
        }

        return users;
    }
}
