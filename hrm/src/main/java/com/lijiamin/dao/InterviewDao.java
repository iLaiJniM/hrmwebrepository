package com.lijiamin.dao;

import com.lijiamin.model.Interview;

import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
public interface InterviewDao {
    Integer insertInterview(Interview interview);    //����������
    Integer deleteInterview(Integer interview_id);    //ɾ��������
    Integer updateInterview(Interview interview);    //����������
    Interview queryInterviewByInterview_id(Integer interview_id);   //������������id����������
    List<Interview> queryInterviewByInterview_user_id(Integer interview_user_id);  //�����û�id���������뼯��
    List<Interview> queryInterviewByInterview_state(Integer interview_state);  //������������״̬���������뼯��
}
