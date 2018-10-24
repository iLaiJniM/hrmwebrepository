package com.lijiamin.service;

import com.lijiamin.model.Recruit;

import java.util.List;

/**
 * Created by 31543 on 2018/10/23.
 */
public interface RecruitService {
    boolean insertRecruit(Recruit recruit);    //����Ƹ
    boolean deleteRecruit(Integer recruit_id);    //ɾ��Ƹ
    boolean updateRecruit(Recruit recruit);    //����Ƹ
    Recruit queryRecruit(Recruit recruit);   //����Ƹ
    List<Recruit> queryRecruitByRecruit_state(Integer recruit_state);  //���ݷ���״̬����Ƹ��Ϣ
}
