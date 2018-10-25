package com.lijiamin.controller;

import com.lijiamin.model.Position;
import com.lijiamin.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping("/queryPosition")
    public String queryPosition(Integer department_id, Model model)throws Exception {
        List<Position> positionList = positionService.queryPositionByPosition_department_id(department_id);
        model.addAttribute("positionList",positionList);
        model.addAttribute("department_id",department_id);
        return "positionQuery";
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

    @RequestMapping("/rectuitQueryPosition")
    public String rectuitQueryPosition(Integer department_id,String department_name, Model model)throws Exception {
        List<Position> positionList = positionService.queryPositionByPosition_department_id(department_id);
        model.addAttribute("positionList",positionList);
        model.addAttribute("department_id",department_id);
        model.addAttribute("department_name",department_name);
        return "rectuitQueryPosition";
    }
}
