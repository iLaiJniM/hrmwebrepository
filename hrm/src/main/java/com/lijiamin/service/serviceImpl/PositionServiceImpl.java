package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.PositionDao;
import com.lijiamin.model.Position;
import com.lijiamin.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;

    public boolean insertPosition(Position position) {
        if(null != position){
            Integer i = positionDao.insertPosition(position);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public boolean deletePosition(Integer position_id) {
        if(null != position_id && position_id > 0){
            Integer i = positionDao.deletePosition(position_id);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public boolean updatePosition(Position position) {
        if(null != position){
            Integer i = positionDao.updatePosition(position);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Position queryPosition(Position position) {
        if(null != position){
            return positionDao.queryPosition(position);
        }
        return null;
    }

    public List<Position> queryPositionByPosition_department_id(Integer position_department_id) {
        if(null != position_department_id && position_department_id > 0) {
            List<Position> positionList = positionDao.queryPositionByPosition_department_id(position_department_id);
            if (positionList.size() > 0) {
                return positionList;
            }
        }
        return null;
    }

    public List<Position> queryPositionAll() {
        List<Position> positionList = positionDao.queryPositionAll();
        if(positionList.size() > 0){
            return positionList;
        }
        return null;
    }
}
