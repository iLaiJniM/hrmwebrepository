package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.RecruitDao;
import com.lijiamin.model.Recruit;
import com.lijiamin.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitDao recruitDao;

    public boolean insertRecruit(Recruit recruit) {
        if(null != recruit){
            Integer i = recruitDao.insertRecruit(recruit);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public boolean deleteRecruit(Integer recruit_id) {
        if(null != recruit_id && recruit_id > 0){
            Integer i = recruitDao.deleteRecruit(recruit_id);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public boolean updateRecruit(Recruit recruit) {
        if(null != recruit){
            Integer i = recruitDao.updateRecruit(recruit);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Recruit queryRecruit(Recruit recruit) {
        if(null != recruit){
            return recruitDao.queryRecruit(recruit);
        }
        return null;
    }

    public List<Recruit> queryRecruitByRecruit_state(Integer recruit_state) {
        if(null != recruit_state){
            List<Recruit> recruitList = recruitDao.queryRecruitByRecruit_state(recruit_state);
            if(recruitList.size() > 0){
                return recruitList;
            }
        }
        return null;
    }
}
