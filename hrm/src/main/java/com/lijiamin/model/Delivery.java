package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/24.
 */
public class Delivery implements Serializable {
    private Integer delivery_id;    //投递id
    private Integer delivery_recruit_id;    //投递的招聘id
    private Integer delivery_resume_id;    //投递的简历id
    private Integer delivery_state;    //投递读取状态
    private Integer delivery_user_id;    //投递的用户id
    private String delivery_resume_name;  //简历里的姓名

    public Delivery() {
    }

    public Delivery(Integer delivery_recruit_id, Integer delivery_resume_id, Integer delivery_state, Integer delivery_user_id, String delivery_resume_name) {
        this.delivery_recruit_id = delivery_recruit_id;
        this.delivery_resume_id = delivery_resume_id;
        this.delivery_state = delivery_state;
        this.delivery_user_id = delivery_user_id;
        this.delivery_resume_name = delivery_resume_name;
    }

    public Integer getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Integer delivery_id) {
        this.delivery_id = delivery_id;
    }

    public Integer getDelivery_recruit_id() {
        return delivery_recruit_id;
    }

    public void setDelivery_recruit_id(Integer delivery_recruit_id) {
        this.delivery_recruit_id = delivery_recruit_id;
    }

    public Integer getDelivery_resume_id() {
        return delivery_resume_id;
    }

    public void setDelivery_resume_id(Integer delivery_resume_id) {
        this.delivery_resume_id = delivery_resume_id;
    }

    public Integer getDelivery_state() {
        return delivery_state;
    }

    public void setDelivery_state(Integer delivery_state) {
        this.delivery_state = delivery_state;
    }

    public Integer getDelivery_user_id() {
        return delivery_user_id;
    }

    public void setDelivery_user_id(Integer delivery_user_id) {
        this.delivery_user_id = delivery_user_id;
    }

    public String getDelivery_resume_name() {
        return delivery_resume_name;
    }

    public void setDelivery_resume_name(String delivery_resume_name) {
        this.delivery_resume_name = delivery_resume_name;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "delivery_id=" + delivery_id +
                ", delivery_recruit_id=" + delivery_recruit_id +
                ", delivery_resume_id=" + delivery_resume_id +
                ", delivery_state=" + delivery_state +
                ", delivery_user_id=" + delivery_user_id +
                ", delivery_resume_name='" + delivery_resume_name + '\'' +
                '}';
    }
}
