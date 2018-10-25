package com.lijiamin.controller;

import com.lijiamin.model.Delivery;
import com.lijiamin.model.Recruit;
import com.lijiamin.model.User;
import com.lijiamin.service.DeliveryService;
import com.lijiamin.service.RecruitService;
import com.lijiamin.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
@Controller
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/insertDelivery")
    public String insertDelivery(Delivery delivery,HttpSession session)throws Exception{
        delivery.setDelivery_state(0);
        delivery.setDelivery_user_id(((User) session.getAttribute("loginUser")).getUser_id());
        delivery.setDelivery_resume_name(resumeService.queryResumeByResume_id(delivery.getDelivery_resume_id()).getResume_name());
        deliveryService.insertDelivery(delivery);
        session.getAttribute("recruitList");
        return "userHomePage";
    }

    @RequestMapping("/queryDelivery")
    public String queryDelivery(Integer delivery_recruit_id,Model model)throws Exception{
        List<Delivery> deliveryList = deliveryService.queryDeliveryByDelivery_recruit_id(delivery_recruit_id);
        model.addAttribute("deliveryList",deliveryList);
        return "deliveryQuery";
    }


}
