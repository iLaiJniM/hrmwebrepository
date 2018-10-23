package com.lijiamin.controller;

import com.lijiamin.model.Resume;
import com.lijiamin.model.User;
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
    private ResumeService resumeService;

    @RequestMapping("/toJsp")
    public String toJsp(String jspName)throws Exception{
        return jspName;
    }

    @RequestMapping("/toJspInterceptor")
    public String toJspInterceptor(String jspName)throws Exception{
        return jspName;
    }

    @RequestMapping("/userLogin")
    public String userLogin(String loginUser_name, String loginUser_pass,String log, HttpSession session, HttpServletResponse response, Model model)throws Exception{
        if(loginUser_name == null || loginUser_name =="" || loginUser_pass == null || loginUser_pass == ""){
            model.addAttribute("msg1","用户名或密码为空");
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
            return toUserHomePage();
        }else {
            model.addAttribute("msg1","登陆失败");
            return "userLogin";
        }
    }

    @RequestMapping("/insertUser")
    public String insertUser(String registerName,String registerPass,Model model) throws Exception {
        if (registerName == "" || registerPass == "") {
            model.addAttribute("msg", "用户名或密码不能为空");
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
        return toUserHomePage();
    }

    @RequestMapping("/exitLoginUser")
    public String exitLoginUser(HttpSession session, HttpServletRequest request)throws Exception {
        session.setAttribute("loginUser",null);
        return toUserHomePage();
    }

    @RequestMapping("/ajaRegisterName")
    public void insertUserajaRegisterName(String ajaregisterName,HttpServletResponse response) throws Exception{
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

    @RequestMapping("/toResumeCenterJspInterceptor")
    public String toResumeCenterJspInterceptor(String jspName,HttpSession session,Model model)throws Exception{
        User user = (User) session.getAttribute("loginUser");
        List<Resume> resumeList = resumeService.queryResumeByResume_user_id(user.getUser_id());
        model.addAttribute("resumeList",resumeList);
        return jspName;
    }

    @RequestMapping("/insertResume")
    public String insertResume(Resume resume,HttpSession session, Model model)throws Exception{
        User user = (User) session.getAttribute("loginUser");
        resume.setResume_user_id(user.getUser_id());
        if(resumeService.insertResume(resume)){
            model.addAttribute("msg", "保存成功");
        }else {
            model.addAttribute("msg","保存失败");
        }
        return "resumeCreate";
    }

    @RequestMapping("/queryResumeByResume_id")
    public String queryResumeByResume_id(Integer resume_id,Model model)throws Exception{
        Resume resume = resumeService.queryResumeByResume_id(resume_id);
        model.addAttribute("resume",resume);
        return "resumeUpdate";
    }

    @RequestMapping("/updateResume")
    public String updateResume(Resume resume, Model model)throws Exception{
        if(resumeService.updateResume(resume)){
            model.addAttribute("msg", "保存成功");
        }else {
            model.addAttribute("msg","保存失败");
        }
        return "resumeUpdate";
    }

    @RequestMapping("/toUserHomePage")
    public String toUserHomePage()throws Exception{
        /*
        待添加
        */
        return "userHomePage";
    }

    @RequestMapping("/deleteResumeByResume_id")
    public String deleteResumeByResume_id(Integer resume_id,Model model,HttpSession session)throws Exception{
        resumeService.deleteResume(new Resume(resume_id));
        String jspName = "resumeCenter";
        return toResumeCenterJspInterceptor(jspName, session, model);
    }

}
