package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.InterviewDao;
import com.lijiamin.model.Interview;
import com.lijiamin.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewDao interviewDao;

    public boolean insertInterview(Interview interview) {
        if(null != interview){
            Integer i = interviewDao.insertInterview(interview);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public boolean deleteInterview(Integer interview_id) {
        if(null != interview_id && interview_id > 0){
            Integer i = interviewDao.deleteInterview(interview_id);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public boolean updateInterview(Interview interview) {
        if(null != interview){
            Integer i = interviewDao.updateInterview(interview);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Interview queryInterviewByInterview_id(Integer interview_id) {
        if(null != interview_id && interview_id > 0) {
            return interviewDao.queryInterviewByInterview_id(interview_id);
        }
        return null;
    }

    public List<Interview> queryInterviewByInterview_user_id(Integer interview_user_id) {
        if(null != interview_user_id && interview_user_id > 0) {
            List<Interview> interviewList = interviewDao.queryInterviewByInterview_user_id(interview_user_id);
            if (interviewList.size() > 0) {
                return interviewList;
            }
        }
        return null;
    }

    public List<Interview> queryInterviewByInterview_state(Integer interview_state) {
        if(null != interview_state && interview_state > 0) {
            List<Interview> interviewList = interviewDao.queryInterviewByInterview_state(interview_state);
            if (interviewList.size() > 0) {
                return interviewList;
            }
        }
        return null;
    }
}
