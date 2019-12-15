package cn.zs.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

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
    @RequestMapping("show2")
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
    }

    /**
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

    /**
     * 上传文件Demo 上传单个文件。
     *
     * @param model
     * @param file
     * @return
     */
    @RequestMapping("upload")
    public String test30(Model model, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null) {
            //将前段传过来的文件存储到指定路径
            file.transferTo(new File("d://upload//" + file.getOriginalFilename()));
        }
        model.addAttribute("msg", "上传成功");
        return "hello";
    }

    /**
     * 上传多个文件，直接对文件进行遍历保存。
     *
     * @param model
     * @param files
     * @return
     * @throws IOException
     */
    public String test31(Model model, @RequestParam("files") MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            if (file != null) {
                // 将前段传过来的文件保存到指定的位置。
                file.transferTo(new File("d://upload//" + file.getOriginalFilename()));
            }
        }
        model.addAttribute("msg", "上传成功");
        return "hello";
    }

    /**
     * 转发
     *
     * @return
     */
    @RequestMapping("show32")
    public String test32() {
        return "forward:show34.do?id=101&name=forward";
    }

    /**
     * 重定向。
     * @return
     */
    @RequestMapping("show33")
    public String test33(){
        return "redirect:show34.do?id=101&name=redirect";
    }

    @RequestMapping("show34")
    public String test34(Model model,@RequestParam("id") String id,@RequestParam("name") String name){
        model.addAttribute("msg","转发还是重定向？？？"+id+"............"+name);
        return "hello01";
    }
}
