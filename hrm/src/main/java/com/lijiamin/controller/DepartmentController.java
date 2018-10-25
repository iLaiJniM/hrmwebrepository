package com.lijiamin.controller;

import com.lijiamin.model.Department;
import com.lijiamin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/toDepartmentCenterJsp")
    public String toDepartmentCenterJsp( Model model)throws Exception {
        List<Department> departmentList = departmentService.queryDepartmentAll();
        model.addAttribute("departmentList",departmentList);
        return "departmentCenter";
    }

    @RequestMapping("/insertDepartment")
    public String insertDepartment(String department_name, HttpSession session, Model model)throws Exception{
        if (department_name == "") {
            model.addAttribute("msg", "���Ʋ���Ϊ��");
            return "departmentCreate";
        }
        Date day=new Date();        //��ȡʱ��
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //��ʽ
        String date = sf.format(day);   //ת��ʽ
        Department department = new Department(department_name,date);
        if(departmentService.insertDepartment(department)){
            model.addAttribute("msg", "��ӳɹ�");
        }else {
            model.addAttribute("msg","���ʧ��");
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
            model.addAttribute("msg", "�ò������Ѵ���");
            return "departmentUpdate";
        }
        if(departmentService.updateDepartment(department)){
            model.addAttribute("msg", "����ɹ�");
        }else {
            model.addAttribute("msg","����ʧ��");
        }
        return "departmentUpdate";
    }

    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(Integer department_id,Model model)throws Exception{
        /*
        * ɾ��ǰ���Ƿ���Ա��
        *
        *
        * */
        departmentService.deleteDepartment(department_id);
        return toDepartmentCenterJsp(model);
    }

    @RequestMapping("/recruitCreate")
    public String recruitCreate( Model model)throws Exception {
        List<Department> departmentList = departmentService.queryDepartmentAll();
        model.addAttribute("departmentList",departmentList);
        return "recruitCreate";
    }
}
