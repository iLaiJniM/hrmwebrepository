package com.lijiamin.controller;

import com.lijiamin.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
@Controller
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @RequestMapping("/interviewCreate")
    public String interviewCreate(Integer interview_user_id,Model model)throws Exception{
        model.addAttribute("interview_user_id",interview_user_id);
        return "interviewCreate";
    }
}
