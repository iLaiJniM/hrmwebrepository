package com.lijiamin.dao;

import com.lijiamin.model.Recruit;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
public interface RecruitDao {
    Integer insertRecruit(Recruit recruit);    //����Ƹ
    Integer deleteRecruit(Integer recruit_id);    //ɾ��Ƹ
    Integer updateRecruit(Recruit recruit);    //����Ƹ
    Recruit queryRecruit(Recruit recruit);   //����Ƹ
    List<Recruit> queryRecruitByRecruit_state(Integer recruit_state);  //���ݷ���״̬����Ƹ��Ϣ
}
