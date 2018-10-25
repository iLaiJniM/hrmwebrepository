package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/24.
 */
public class Delivery implements Serializable {
    private Integer delivery_id;    //Ͷ��id
    private Integer delivery_recruit_id;    //Ͷ�ݵ���Ƹid
    private Integer delivery_resume_id;    //Ͷ�ݵļ���id
    private Integer delivery_state;    //Ͷ�ݶ�ȡ״̬
    private Integer delivery_user_id;    //Ͷ�ݵ��û�id
    private String delivery_resume_name;  //�����������

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
