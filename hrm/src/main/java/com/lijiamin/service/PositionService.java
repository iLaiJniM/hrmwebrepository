package com.lijiamin.service;

import com.lijiamin.model.Position;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
public interface PositionService {
    boolean insertPosition(Position position);    //��ְλ
    boolean deletePosition(Integer position_id);    //ɾְλ
    boolean updatePosition(Position position);    //��ְλ
    Position queryPosition(Position position);   //��ְλ
    List<Position> queryPositionByPosition_department_id(Integer position_department_id);  //���ݲ���id��ְλ
    List<Position> queryPositionAll();  //������ְλ
}
