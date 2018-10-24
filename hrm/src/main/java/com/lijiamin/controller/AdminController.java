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
import java.text.SimpleDateFormat;
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
        Date day=new Date();        //获取时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //格式
        String date = sf.format(day);   //转格式
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
        /*
        * 删除前看是否有员工
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
            model.addAttribute("msg", "名称不能为空");
            return "positionCreate";
        }
        if(null != positionService.queryPosition(new Position(position_name,department_id))){
            model.addAttribute("msg", "该部门已存在此职位");
            return "positionCreate";
        }
        Date day=new Date();        //获取时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //格式
        String date = sf.format(day);   //转格式
        Position position = new Position(position_name,date,department_id);
        if(positionService.insertPosition(position)){
            model.addAttribute("msg", "添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
        return "positionCreate";
    }

    @RequestMapping("/deletePosition")
    public String deletePosition(Integer department_id,Integer position_id,Model model)throws Exception{
        model.addAttribute("department_id",department_id);
        /*
        * 删除前看是否有员工
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
            model.addAttribute("msg", "名称不能为空");
            return "positionUpdate";
        }
        if(null != positionService.queryPosition(new Position(position_name,department_id))){
            model.addAttribute("msg", "该部门已存在此职位");
            return "positionUpdate";
        }
        Position position1 = new Position(position_name);
        position1.setPosition_id(position_id);
        model.addAttribute("position",position1);
        if(positionService.updatePosition(position1)){
            model.addAttribute("msg", "保存成功");
        }else {
            model.addAttribute("msg","保存失败");
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
    public String rectuitQueryPosition(Integer department_id,String department_name, Model model)throws Exception {
        List<Position> positionList = positionService.queryPositionByPosition_department_id(department_id);
        model.addAttribute("positionList",positionList);
        model.addAttribute("department_id",department_id);
        model.addAttribute("department_name",department_name);
        return "rectuitQueryPosition";
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
    public String insertRecruit(Recruit recruit,Integer recruit_salary,Model model)throws Exception {
        Date day=new Date();        //获取时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  //格式
        String date = sf.format(day);   //转格式
        recruit.setRecruit_createtime(date);
        recruit.setRecruit_state(0);    //未发布
        System.out.println(recruit);
        if(recruitService.insertRecruit(recruit)){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
        return "rectuitSetSalary";
    }

    @RequestMapping("/unpublishedRecruit")
    public String unpublishedRecruit(Model model)throws Exception{
        List<Recruit> recruitList = recruitService.queryRecruitByRecruit_state(0);
        model.addAttribute("recruitList",recruitList);
        return "recruitUnpublished";
    }


}
