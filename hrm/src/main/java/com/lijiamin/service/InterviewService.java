package com.lijiamin.service;

import com.lijiamin.model.Interview;

import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
public interface InterviewService {
    boolean insertInterview(Interview interview);    //添面试邀请
    boolean deleteInterview(Integer interview_id);    //删面试邀请
    boolean updateInterview(Interview interview);    //改面试邀请
    Interview queryInterviewByInterview_id(Integer interview_id);   //根据id查面试邀请
    List<Interview> queryInterviewByInterview_user_id(Integer interview_user_id);  //根据用户id查面试邀请集合
    List<Interview> queryInterviewByInterview_state(Integer interview_state);  //根据面试邀请状态查面试邀请集合
}
