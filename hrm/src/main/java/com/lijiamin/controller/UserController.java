package com.lijiamin.controller;

import com.lijiamin.model.User;
import com.lijiamin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 31543 on 2018/10/19.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toJsp")
    public String toJsp(String jspName){
        return jspName;
    }

    @RequestMapping("/toJspInterceptor")
    public String toJspInterceptor(String jspName){
        return jspName;
    }

    @RequestMapping("/userLogin")
    public String userLogin(String loginUser_name, String loginUser_pass,String log, HttpSession session, HttpServletResponse response, Model model){
        User loginUser = userService.queryUser(new User(loginUser_name,loginUser_pass));
        if( loginUser != null){
            session.setAttribute("loginUser",loginUser);
            if("on".equals(log)){
                Cookie cookie = new Cookie("loginName",loginUser.getUser_name());
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
            }
            return "../../index";
        }else {
            model.addAttribute("msg1","登陆失败");
            return "userLogin";
        }
    }

    @RequestMapping("/insertUser")
    public String insertUser(String registerName,String registerPass,Model model) {
        if (registerName == "" || registerPass == "") {
            model.addAttribute("msg", "注册失败");
            return "userRegister";
        }
        User user = new User(registerName, registerPass);
        if (userService.insertUser(user)) {
            model.addAttribute("msg", "注册成功");
        } else {
            model.addAttribute("msg", "注册失败");
        }
        return "userRegister";
    }

    @RequestMapping("/autoLogin")
    public String autoLogin(HttpSession session, HttpServletRequest request, Model model)throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            if ("loginName".equals(name) && userService.queryUser(new User(value)) != null) {
                User user = userService.queryUser(new User(value));
                session.setAttribute("loginUser",user);
            }
        }
        return "../../index";
    }

    @RequestMapping("/ajaRegisterName")
    public void insertUserajaRegisterName(String ajaregisterName,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        //ajax验证用户名
        try {
            if(ajaregisterName==null||ajaregisterName.equals("")) {
                response.getWriter().print("请输入用户名");
            }else if(userService.queryUser(new User(ajaregisterName)) != null){
                response.getWriter().print("用户名已存在");
            }else {
                response.getWriter().print("√");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
