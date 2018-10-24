package com.lijiamin.dao;

import com.lijiamin.model.Recruit;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
public interface RecruitDao {
    Integer insertRecruit(Recruit recruit);    //添招聘
    Integer deleteRecruit(Integer recruit_id);    //删招聘
    Integer updateRecruit(Recruit recruit);    //改招聘
    Recruit queryRecruit(Recruit recruit);   //查招聘
    List<Recruit> queryRecruitByRecruit_state(Integer recruit_state);  //根据发布状态查招聘信息
}
