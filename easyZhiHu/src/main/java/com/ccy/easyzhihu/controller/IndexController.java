package com.ccy.easyzhihu.controller;

import com.ccy.easyzhihu.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author chengcongyue
 * @version 1.0
 * @description com.ccy.easyzhihu.controller
 * @date 2019/3/23
 */
@Controller
public class IndexController {

    @RequestMapping(path={"/"})
    @ResponseBody
    public String index()
    {
        return "hello";
    }

    @RequestMapping("/hello")
    public String redictHome(Model model)
    {
        model.addAttribute("name","huangtianhao" );
        List<String> colors= Arrays.asList("red","green","blue");
        model.addAttribute("colors",colors );
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"hello");
        map.put(2,"no hello");
        map.put(3,"right");
        model.addAttribute("myMap",map);
        User user=new User();
        user.setName("huangtianhao");
        user.setAge(23);
        model.addAttribute("user",user);
        return "hello";
    }

    @RequestMapping(path = {"/request"})
    @ResponseBody
    public String request(Model model, HttpServletResponse response, HttpServletRequest request, HttpSession session)
    {

           StringBuilder sb=new StringBuilder();
           sb.append(request.getMethod()+"<br>");//get
           sb.append(request.getQueryString()+"<br>");//null
           sb.append(request.getPathInfo()+"<br>");//null
           sb.append(request.getRequestURI()+"<br>");//request
           return sb.toString();
    }
}
