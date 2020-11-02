package com.whj.contrller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/demo")//根
public class DemoController {
    /**
     * url: http://localhost:8080/demo/handle01
     */
    @RequestMapping("/handle01")
    public ModelAndView handle01(){
        Date date = new Date();// 服务器时间
        //返回服务器时间到前台页面
        //封装了数据和页面信息的模型 ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //addObject:像请求域中 request.serAttribute("date",date);
        modelAndView.addObject("date",date);
        //视图信息(封装跳转的页面信息) WEB-INF中新建一个jsp目录
        modelAndView.setViewName("success");//设置逻辑视图名 也就是/WEB-INF/jsp/success.jsp
        return modelAndView;
    }
}
