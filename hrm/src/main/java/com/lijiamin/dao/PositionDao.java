package com.lijiamin.dao;

import com.lijiamin.model.Position;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
public interface PositionDao {
    Integer insertPosition(Position position);    //添职位
    Integer deletePosition(Integer position_id);    //删职位
    Integer updatePosition(Position position);    //改职位
    Position queryPosition(Position position);   //查职位
    List<Position> queryPositionByPosition_department_id(Integer position_department_id);  //根据部门id查职位
    List<Position> queryPositionAll();  //查所有职位
}
