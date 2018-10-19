package com.lijiamin.controller;

import com.lijiamin.model.User;
import com.lijiamin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/userLogin")
    public String userLogin(String loginUser_name, String loginUser_pass, HttpSession session, HttpServletResponse response, Model model){
        User loginUser = userService.queryUser(new User(loginUser_name,loginUser_pass));
        if( loginUser != null){
            session.setAttribute("loginUser",loginUser);
            return "userHomePage";
        }else {
            model.addAttribute("msg1","��½ʧ��");
            return "../../index";
        }
    }

    @RequestMapping("/insertUser")
    public String insertUser(String registerName,String registerPass,Model model) {
        if (registerName == "" || registerPass == "") {
            model.addAttribute("msg", "ע��ʧ��");
            return "register";
        }
        User user = new User(registerName, registerPass);
        if (userService.insertUser(user)) {
            model.addAttribute("msg", "ע��ɹ�");
        } else {
            model.addAttribute("msg", "ע��ʧ��");
        }
        return "register";
    }

    @RequestMapping("/ajaRegisterName")
    public void insertUserajaRegisterName(String ajaregisterName,HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        //ajax��֤�û���
        try {
            if(ajaregisterName==null||ajaregisterName.equals("")) {
                response.getWriter().print("�������û���");
            }else if(userService.queryUser(new User(ajaregisterName)) != null){
                response.getWriter().print("�û����Ѵ���");
            }else {
                response.getWriter().print("��");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
