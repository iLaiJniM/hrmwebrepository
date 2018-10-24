package com.lijiamin.service;

import com.lijiamin.model.Recruit;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
public interface RecruitService {
    boolean insertRecruit(Recruit recruit);    //添招聘
    boolean deleteRecruit(Integer recruit_id);    //删招聘
    boolean updateRecruit(Recruit recruit);    //改招聘
    Recruit queryRecruit(Recruit recruit);   //查招聘
    List<Recruit> queryRecruitByRecruit_state(Integer recruit_state);  //根据发布状态查招聘信息
}
