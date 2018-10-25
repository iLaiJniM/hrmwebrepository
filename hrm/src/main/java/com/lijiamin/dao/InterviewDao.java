package com.lijiamin.dao;

import com.lijiamin.model.Interview;

import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
public interface InterviewDao {
    Integer insertInterview(Interview interview);    //添面试邀请
    Integer deleteInterview(Integer interview_id);    //删面试邀请
    Integer updateInterview(Interview interview);    //改面试邀请
    Interview queryInterviewByInterview_id(Integer interview_id);   //根据面试邀请id查面试邀请
    List<Interview> queryInterviewByInterview_user_id(Integer interview_user_id);  //根据用户id查面试邀请集合
    List<Interview> queryInterviewByInterview_state(Integer interview_state);  //根据面试邀请状态查面试邀请集合
}
