package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/25.
 */
public class Offer implements Serializable {
    private Integer offer_id;   //录用通知id
    private String offer_resume_name;   //录用人姓名
    private String offer_depart_name;   //录用部门
    private String offer_position_name; //录用职位
    private Integer offer_user_id;  //录用用户id

    public Offer() {
    }

    public Offer(String offer_resume_name, String offer_depart_name, String offer_position_name, Integer offer_user_id) {
        this.offer_resume_name = offer_resume_name;
        this.offer_depart_name = offer_depart_name;
        this.offer_position_name = offer_position_name;
        this.offer_user_id = offer_user_id;
    }

    public Integer getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(Integer offer_id) {
        this.offer_id = offer_id;
    }

    public String getOffer_resume_name() {
        return offer_resume_name;
    }

    public void setOffer_resume_name(String offer_resume_name) {
        this.offer_resume_name = offer_resume_name;
    }

    public String getOffer_depart_name() {
        return offer_depart_name;
    }

    public void setOffer_depart_name(String offer_depart_name) {
        this.offer_depart_name = offer_depart_name;
    }

    public String getOffer_position_name() {
        return offer_position_name;
    }

    public void setOffer_position_name(String offer_position_name) {
        this.offer_position_name = offer_position_name;
    }

    public Integer getOffer_user_id() {
        return offer_user_id;
    }

    public void setOffer_user_id(Integer offer_user_id) {
        this.offer_user_id = offer_user_id;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offer_id=" + offer_id +
                ", offer_resume_name='" + offer_resume_name + '\'' +
                ", offer_depart_name='" + offer_depart_name + '\'' +
                ", offer_position_name='" + offer_position_name + '\'' +
                ", offer_user_id=" + offer_user_id +
                '}';
    }
}
