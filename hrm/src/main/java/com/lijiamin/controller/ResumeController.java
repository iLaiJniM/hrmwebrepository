package com.lijiamin.controller;

import com.lijiamin.model.Delivery;
import com.lijiamin.model.Resume;
import com.lijiamin.model.User;
import com.lijiamin.service.DeliveryService;
import com.lijiamin.service.InterviewService;
import com.lijiamin.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("/toResumeCenterJspInterceptor")
    public String toResumeCenterJspInterceptor(String jspName, HttpSession session, Model model)throws Exception{
        User user = (User) session.getAttribute("loginUser");
        List<Resume> resumeList = resumeService.queryResumeByResume_user_id(user.getUser_id());
        model.addAttribute("resumeList",resumeList);
        return jspName;
    }

    @RequestMapping("/insertResume")
    public String insertResume(Resume resume,HttpSession session, Model model)throws Exception{
        User user = (User) session.getAttribute("loginUser");
        resume.setResume_user_id(user.getUser_id());
        if(resumeService.insertResume(resume)){
            model.addAttribute("msg", "保存成功");
        }else {
            model.addAttribute("msg","保存失败");
        }
        return "resumeCreate";
    }

    @RequestMapping("/queryResumeByResume_id")
    public String queryResumeByResume_id(Integer resume_id,Model model)throws Exception{
        Resume resume = resumeService.queryResumeByResume_id(resume_id);
        model.addAttribute("resume",resume);
        return "resumeUpdate";
    }

    @RequestMapping("/updateResume")
    public String updateResume(Resume resume, Model model)throws Exception{
        if(resumeService.updateResume(resume)){
            model.addAttribute("msg", "保存成功");
        }else {
            model.addAttribute("msg","保存失败");
        }
        return "resumeUpdate";
    }

    @RequestMapping("/deleteResumeByResume_id")
    public String deleteResumeByResume_id(Integer resume_id,Model model,HttpSession session)throws Exception{
        resumeService.deleteResume(new Resume(resume_id));
        String jspName = "resumeCenter";
        return toResumeCenterJspInterceptor(jspName, session, model);
    }

    @RequestMapping("/selectResume")
    public String selectResume(Integer recruit_id,Model model,HttpSession session)throws Exception{
        User loginUser = (User) session.getAttribute("loginUser");
        List<Resume> resumeList = resumeService.queryResumeByResume_user_id(loginUser.getUser_id());
        model.addAttribute("resumeList",resumeList);
        model.addAttribute("recruit_id",recruit_id);
        return "resumeSelect";
    }

    @RequestMapping("/queryResumeByDelivery_resume_id")
    public String queryResumeByDelivery_resume_id(Integer delivery_id, Integer delivery_resume_id, Integer delivery_recruit_id,Model model)throws Exception{
        Delivery delivery1 = deliveryService.queryDelivery(delivery_id);
        delivery1.setDelivery_state(1);
        deliveryService.updateDelivery(delivery1);
        Resume resume = resumeService.queryResumeByResume_id(delivery_resume_id);
        model.addAttribute("resume",resume);
        model.addAttribute("delivery_recruit_id",delivery_recruit_id);
        return "resumeQuery";
    }
}
