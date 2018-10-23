package com.lijiamin.controller;

import com.lijiamin.model.Department;
import com.lijiamin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by 31543 on 2018/10/22.
 */
@Controller
public class AdminController {
    @Autowired
    private DepartmentService departmentService;

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

    @RequestMapping("/toDepartmentCenterJsp")
    public String toDepartmentCenterJsp( Model model)throws Exception {
        List<Department> departmentList = departmentService.queryDepartmentAll();
        model.addAttribute("departmentList",departmentList);
        return "departmentCenter";
    }

    @RequestMapping("/toAdminHomePage")
    public String toAdminHomePage()throws Exception{
        return "adminHomePage";
    }

    @RequestMapping("/toRecruitCenterJsp")
    public String toRecruitCenterJsp()throws Exception{
        return "recruitCenter";
    }

    @RequestMapping("/toTrainCenterJsp")
    public String toTrainCenterJsp()throws Exception{
        return "trainCenter";
    }

    @RequestMapping("/insertDepartment")
    public String insertDepartment(String department_name,HttpSession session, Model model)throws Exception{
        if (department_name == "") {
            model.addAttribute("msg", "名称不能为空");
            return "departmentCreate";
        }
        Date currentDate=new Date();
        String date=currentDate.toString();//获取当前时间的字符串类型
        Department department = new Department(department_name,date);
        if(departmentService.insertDepartment(department)){
            model.addAttribute("msg", "添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
        return "departmentCreate";
    }

    @RequestMapping("/queryDepartment")
    public String queryDepartment(Department department,Model model)throws Exception{
        Department department1 = departmentService.queryDepartment(department);
        model.addAttribute("department",department1);
        return "departmentUpdate";
    }

    @RequestMapping("/updateDepartment")
    public String updateDepartment(Department department, Model model)throws Exception{
        Department department1 = new Department(department.getDepartment_name());
        if(null != departmentService.queryDepartment(department1)){
            model.addAttribute("msg", "该部门名已存在");
            return "departmentUpdate";
        }
        if(departmentService.updateDepartment(department)){
            model.addAttribute("msg", "保存成功");
        }else {
            model.addAttribute("msg","保存失败");
        }
        return "departmentUpdate";
    }

    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(Integer department_id,Model model)throws Exception{
        departmentService.deleteDepartment(department_id);
        return toDepartmentCenterJsp(model);
    }
}
