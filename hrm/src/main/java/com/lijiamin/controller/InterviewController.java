package com.lijiamin.controller;

import com.lijiamin.model.Interview;
import com.lijiamin.model.Recruit;
import com.lijiamin.model.User;
import com.lijiamin.service.InterviewService;
import com.lijiamin.service.RecruitService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
@Controller
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private RecruitService recruitService;

    @RequestMapping("/interviewCreate")
    public String interviewCreate(Integer interview_user_id,Integer interview_resume_id,Integer delivery_recruit_id,String interview_resume_name,Model model)throws Exception{
        model.addAttribute("interview_user_id",interview_user_id);
        model.addAttribute("interview_resume_id",interview_resume_id);
        model.addAttribute("delivery_recruit_id",delivery_recruit_id);
        model.addAttribute("interview_resume_name",interview_resume_name);
        Recruit recruit1 = new Recruit();
        recruit1.setRecruit_id(delivery_recruit_id);
        Recruit recruit = recruitService.queryRecruit(recruit1);
        model.addAttribute("recruit_department_name",recruit.getRecruit_department_name());
        model.addAttribute("recruit_position_name",recruit.getRecruit_position_name());
        return "interviewCreate";
    }

    @RequestMapping("/insertInterview")
    public String insertInterview(Interview interview, Model model)throws Exception{
        interview.setInterview_state(0);
        interviewService.insertInterview(interview);
        model.addAttribute("delivery_recruit_id",interview.getInterview_recruit_id());
        model.addAttribute("msg", "添加面试通知成功");
        return interviewCreate(interview.getInterview_user_id(),interview.getInterview_resume_id(),interview.getInterview_recruit_id(),interview.getInterview_resume_name(),model);
    }

    @RequestMapping("/toInterviewInvitationJspInterceptor")
    public String toInterviewInvitationJspInterceptor(HttpSession session, Model model)throws Exception{
        User user = (User) session.getAttribute("loginUser");
        List<Interview> interviewList = interviewService.queryInterviewByInterview_user_id(user.getUser_id());
        model.addAttribute("interviewList",interviewList);
        return "interviewInvitation";
    }

    @RequestMapping("/confirmInterview")
    public String confirmInterview(Integer interview_id, HttpSession session,Model model)throws Exception{
        Interview interview = interviewService.queryInterviewByInterview_id(interview_id);
        interview.setInterview_state(1);
        interviewService.updateInterview(interview);
        return toInterviewInvitationJspInterceptor(session,model);
    }

    @RequestMapping("/employ")
    public String employ(Model model)throws Exception{
        List<Interview> interviewList = interviewService.queryInterviewByInterview_state(1);
        model.addAttribute("interviewList",interviewList);
        return "employ";
    }

    @RequestMapping("/deleteInterview")
    public String deleteInterview(Integer interview_id,Model model)throws Exception{
        interviewService.deleteInterview(interview_id);
        return employ(model);
    }






}
