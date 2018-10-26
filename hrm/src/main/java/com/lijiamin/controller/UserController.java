package com.lijiamin.controller;

import com.lijiamin.model.Recruit;
import com.lijiamin.model.Resume;
import com.lijiamin.model.User;
import com.lijiamin.service.RecruitService;
import com.lijiamin.service.ResumeService;
import com.lijiamin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by 31543 on 2018/10/19.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RecruitService recruitService;

    @RequestMapping("/toJsp")
    public String toJsp(String jspName)throws Exception{
        return jspName;
    }

    @RequestMapping("/userLogin")
    public String userLogin(String loginUser_name, String loginUser_pass,String log, HttpSession session, HttpServletResponse response, Model model)throws Exception{
        if(loginUser_name == null || loginUser_name =="" || loginUser_pass == null || loginUser_pass == ""){
            model.addAttribute("msg1","�û���������Ϊ��");
            return "userLogin";
        }
        User loginUser = userService.queryUser(new User(loginUser_name,loginUser_pass));
        if( loginUser != null){
            session.setAttribute("loginUser",loginUser);
            if("on".equals(log)){
                Cookie cookie = new Cookie("loginName",loginUser.getUser_name());
                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
            }
            return toUserHomePage(session);
        }else {
            model.addAttribute("msg1","��½ʧ��");
            return "userLogin";
        }
    }

    @RequestMapping("/insertUser")
    public String insertUser(String registerName,String registerPass,Model model) throws Exception {
        if (registerName == "" || registerPass == "") {
            model.addAttribute("msg", "�û��������벻��Ϊ��");
            return "userRegister";
        }
        User user = new User(registerName, registerPass);
        if (userService.insertUser(user)) {
            model.addAttribute("msg", "ע��ɹ�");
        } else {
            model.addAttribute("msg", "ע��ʧ��");
        }
        return "userRegister";
    }

    @RequestMapping("/autoLogin")
    public String autoLogin(HttpSession session, HttpServletRequest request)throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            if ("loginName".equals(name) && userService.queryUser(new User(value)) != null) {
                User user = userService.queryUser(new User(value));
                session.setAttribute("loginUser",user);
            }
        }
        return toUserHomePage(session);
    }

    @RequestMapping("/exitLoginUser")
    public String exitLoginUser(HttpSession session)throws Exception {
        session.setAttribute("loginUser",null);
        return toUserHomePage(session);
    }

    @RequestMapping("/ajaRegisterName")
    public void insertUserajaRegisterName(String ajaregisterName,HttpServletResponse response) throws Exception{
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

    @RequestMapping("/toUserHomePage")
    public String toUserHomePage(HttpSession session)throws Exception{
        List<Recruit> recruitList = recruitService.queryRecruitByRecruit_state(1);
        session.setAttribute("recruitList",recruitList);
        return "userHomePage";
    }
}
