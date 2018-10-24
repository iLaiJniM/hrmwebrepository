package com.lijiamin.controller;

import com.lijiamin.model.Department;
import com.lijiamin.model.Position;
import com.lijiamin.model.Recruit;
import com.lijiamin.service.DepartmentService;
import com.lijiamin.service.PositionService;
import com.lijiamin.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Autowired
    private PositionService positionService;
    @Autowired
    private RecruitService recruitService;

    @RequestMapping("/adminLogin")
    public String userLogin(String loginAdmin_name, String loginAdmin_pass, HttpSession session, HttpServletResponse response, Model model)throws Exception{
        if(loginAdmin_name == null || loginAdmin_name =="" || loginAdmin_pass == null || loginAdmin_pass == ""){
            model.addAttribute("msg1","�û���������Ϊ��");
            return "adminLogin";
        }
        if(loginAdmin_name.equals("admin") && loginAdmin_pass.equals("admin")){
            session.setAttribute("loginAdmin_name",loginAdmin_name);
            return "adminHomePage";
        } else {
            model.addAttribute("msg1","��½ʧ��");
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

    @RequestMapping("/toTrainCenterJsp")
    public String toTrainCenterJsp()throws Exception{
        return "trainCenter";
    }

    @RequestMapping("/insertDepartment")
    public String insertDepartment(String department_name,HttpSession session, Model model)throws Exception{
        if (department_name == "") {
            model.addAttribute("msg", "���Ʋ���Ϊ��");
            return "departmentCreate";
        }
        Date currentDate=new Date();
        String date=currentDate.toString();//��ȡ��ǰʱ����ַ�������
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

    @RequestMapping("/queryPosition")
    public String queryPosition(Integer department_id, Model model)throws Exception {
        List<Position> positionList = positionService.queryPositionByPosition_department_id(department_id);
        model.addAttribute("positionList",positionList);
        model.addAttribute("department_id",department_id);
        return "positionQuery";
    }

    @RequestMapping("/positionCreate")
    public String positionCreate(Integer department_id, Model model)throws Exception {
        model.addAttribute("department_id",department_id);
        return "positionCreate";
    }

    @RequestMapping("/insertPosition")
    public String insertPosition(Integer department_id,String position_name, Model model)throws Exception{
        model.addAttribute("department_id",department_id);
        if (position_name == "") {
            model.addAttribute("msg", "���Ʋ���Ϊ��");
            return "positionCreate";
        }
        if(null != positionService.queryPosition(new Position(position_name,department_id))){
            model.addAttribute("msg", "�ò����Ѵ��ڴ�ְλ");
            return "positionCreate";
        }
        Date currentDate=new Date();
        String date=currentDate.toString();//��ȡ��ǰʱ����ַ�������
        Position position = new Position(position_name,date,department_id);
        if(positionService.insertPosition(position)){
            model.addAttribute("msg", "��ӳɹ�");
        }else {
            model.addAttribute("msg","���ʧ��");
        }
        return "positionCreate";
    }

    @RequestMapping("/deletePosition")
    public String deletePosition(Integer department_id,Integer position_id,Model model)throws Exception{
        model.addAttribute("department_id",department_id);
        /*
        * ɾ��ǰ���Ƿ���Ա��
        *
        *
        * */
        positionService.deletePosition(position_id);
        return queryPosition(department_id,model);
    }

    @RequestMapping("/toUpdatePosition")
    public String toUpdatePosition(Integer position_id,Integer department_id,Model model)throws Exception{
        Position position = positionService.queryPosition(new Position(position_id));
        model.addAttribute("position",position);
        model.addAttribute("department_id",department_id);
        return "positionUpdate";
    }

    @RequestMapping("/updatePosition")
    public String updatePosition(Integer department_id,Integer position_id,String position_name, Model model)throws Exception{
        model.addAttribute("department_id",department_id);
        if(null == position_name || position_name=="") {
            model.addAttribute("msg", "���Ʋ���Ϊ��");
            return "positionUpdate";
        }
        if(null != positionService.queryPosition(new Position(position_name,department_id))){
            model.addAttribute("msg", "�ò����Ѵ��ڴ�ְλ");
            return "positionUpdate";
        }
        Position position1 = new Position(position_name);
        position1.setPosition_id(position_id);
        model.addAttribute("position",position1);
        if(positionService.updatePosition(position1)){
            model.addAttribute("msg", "����ɹ�");
        }else {
            model.addAttribute("msg","����ʧ��");
        }
        return "positionUpdate";
    }

    @RequestMapping("/toRecruitCenterJsp")
    public String toRecruitCenterJsp(Model model)throws Exception{
        List<Recruit> recruitList = recruitService.queryRecruitByRecruit_state(1);
        model.addAttribute("recruitList",recruitList);
        return "recruitCenter";
    }

    @RequestMapping("/recruitCreate")
    public String recruitCreate( Model model)throws Exception {
        List<Department> departmentList = departmentService.queryDepartmentAll();
        model.addAttribute("departmentList",departmentList);
        return "recruitCreate";
    }

    @RequestMapping("/rectuitQueryPosition")
    public String rectuitQueryPosition(Department department,Model model)throws Exception{
        Department department1 = departmentService.queryDepartment(department);
        model.addAttribute("department",department1);
        return "departmentUpdate";
    }
}
