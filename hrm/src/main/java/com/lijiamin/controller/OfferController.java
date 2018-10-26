package com.lijiamin.controller;

import com.lijiamin.model.*;
import com.lijiamin.service.*;
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
public class OfferController {
    @Autowired
    private OfferService offerService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private RecruitService recruitService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    @RequestMapping("/employUser")
    public String employUser(Offer offer,Integer interview_resume_id, Integer interview_recruit_id,Integer interview_id, HttpSession session, Model model)throws Exception{
        offerService.insertOffer(offer);
        User user = userService.queryUser(new User(offer.getOffer_user_id()));
        Resume resume = resumeService.queryResumeByResume_id(interview_resume_id);
        Recruit recruit = new Recruit();
        recruit.setRecruit_id(interview_recruit_id);
        Recruit recruit1 = recruitService.queryRecruit(recruit);
        Employee employee = new Employee(user.getUser_name(), user.getUser_pass(), resume.getResume_name(), resume.getResume_phone(), resume.getResume_sex(), recruit1.getRecruit_department_id(), recruit1.getRecruit_position_id(), recruit1.getRecruit_salary(), 1, resume.getResume_age());
        employeeService.insertEmployee(employee);
        interviewService.deleteInterview(interview_id);
        List<Interview> interviewList = interviewService.queryInterviewByInterview_state(1);
        model.addAttribute("interviewList",interviewList);
        return "employ";
    }

    @RequestMapping("/toJspInterceptor")
    public String toJspInterceptor(HttpSession session,Model model)throws Exception{
        List<Offer> offerList = offerService.queryOfferByOffer_user_id(((User) session.getAttribute("loginUser")).getUser_id());
        model.addAttribute("offerList",offerList);
        return "interviewResults";
    }
}
