package com.lijiamin.controller;

import com.lijiamin.model.*;
import com.lijiamin.service.DepartmentService;
import com.lijiamin.service.PositionService;
import com.lijiamin.service.RecruitService;
import com.lijiamin.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 31543 on 2018/10/22.
 */
@Controller
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    @RequestMapping("/adminLogin")
    public String userLogin(String loginAdmin_name, String loginAdmin_pass, HttpSession session, HttpServletResponse response, Model model)throws Exception{
        if(loginAdmin_name == null || loginAdmin_name =="" || loginAdmin_pass == null || loginAdmin_pass == ""){
            model.addAttribute("msg1","用户名或密码为空");
            return "adminLogin";
        }
        if(loginAdmin_name.equals("admin") && loginAdmin_pass.equals("admin")){
            session.setAttribute("loginAdmin_name",loginAdmin_name);
            return "adminHomePage";
        } else {
            model.addAttribute("msg1","登陆失败");
            return "adminLogin";
        }
    }

    @RequestMapping("/exitLoginAdmin")
    public String exitLoginAdmin(HttpSession session)throws Exception {
        session.setAttribute("loginAdmin_name",null);
        return "userHomePage";
    }

    @RequestMapping("/toJsp1")
    public String toJsp1(String jspName)throws Exception{
        return jspName;
    }

    @RequestMapping("/toAdminHomePage")
    public String toAdminHomePage()throws Exception{
        return "adminHomePage";
    }

    @RequestMapping("/toTrainCenterJsp")
    public String toTrainCenterJsp()throws Exception{
        return "trainCenter";
    }

    @RequestMapping("/positionCreate")
    public String positionCreate(Integer department_id, Model model)throws Exception {
        model.addAttribute("department_id",department_id);
        return "positionCreate";
    }

    @RequestMapping("/toRecruitCenterJsp")
    public String toRecruitCenterJsp(Model model)throws Exception{
        List<Recruit> recruitList = recruitService.queryRecruitByRecruit_state(1);
        model.addAttribute("recruitList",recruitList);
        return "recruitCenter";
    }

    @RequestMapping("/rectuitSetSalary")
    public String rectuitSetSalary(Integer recruit_department_id,String recruit_department_name,Integer recruit_position_id,String recruit_position_name,Model model)throws Exception {
        model.addAttribute("recruit_department_id",recruit_department_id);
        model.addAttribute("recruit_department_name",recruit_department_name);
        model.addAttribute("recruit_position_id",recruit_position_id);
        model.addAttribute("recruit_position_name",recruit_position_name);
        return "rectuitSetSalary";
    }

    @RequestMapping("/insertRecruit")
    public String insertRecruit(Recruit recruit,Model model)throws Exception {
        recruit.setRecruit_state(0);    //未发布
        recruit.setRecruit_createtime("");
        if(recruitService.insertRecruit(recruit)){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
        return "rectuitSetSalary";
    }

    @RequestMapping("/deleteRecruit")
    public String deleteRecruit(Integer recruit_id , Model model)throws Exception{
        recruitService.deleteRecruit(recruit_id);
        return unpublishedRecruit(model);
    }

    @RequestMapping("/unpublishedRecruit")
    public String unpublishedRecruit(Model model)throws Exception{
        List<Recruit> recruitList = recruitService.queryRecruitByRecruit_state(0);
        model.addAttribute("recruitList",recruitList);
        return "recruitUnpublished";
    }

    @RequestMapping("/publishRecruit")
    public String publishRecruit(Recruit recruit ,Model model)throws Exception{
        Recruit recruit1 = recruitService.queryRecruit(recruit);
        Date day=new Date();        //获取时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //格式
        String date = sf.format(day);   //转格式
        recruit1.setRecruit_createtime(date);
        recruit1.setRecruit_state(1);
        recruitService.updateRecruit(recruit1);
        return unpublishedRecruit(model);
    }

    @RequestMapping("/deleteRecruit1")
    public String deleteRecruit1(Integer recruit_id , Model model)throws Exception{
        recruitService.deleteRecruit(recruit_id);
        return toRecruitCenterJsp(model);
    }

    @RequestMapping("/queryRecruit")
    public String queryRecruit(Recruit recruit,Model model)throws Exception{
        Recruit recruit1 = recruitService.queryRecruit(recruit);
        model.addAttribute("recruit",recruit1);
        return "recruitUpdate";
    }

    @RequestMapping("/updateRecruitSalary")
    public String updateRecruitSalary(Integer recruit_id, Integer recruit_salary,Model model)throws Exception{
        Recruit recruit1 = new Recruit();
        recruit1.setRecruit_id(recruit_id);
        Recruit recruit2 = recruitService.queryRecruit(recruit1);
        recruit2.setRecruit_salary(recruit_salary);
        recruit2.setRecruit_createtime("");
        recruitService.updateRecruit(recruit2);
        return unpublishedRecruit(model);
    }




}
