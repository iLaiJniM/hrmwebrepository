package com.lijiamin.model;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/20.
 */
public class Resume implements Serializable {
    private Integer resume_id;  //简历id
    private String resume_designation;  //简历名
    private Integer resume_user_id; //用户id
    private String resume_name; //姓名
    private String resume_sex;  //性别
    private Integer resume_age;  //年龄
    private String resume_phone;   //手机号
    private String resume_education;    //最高学历
    private String resume_school;   //毕业院校
    private String resume_major;    //专业
    private Integer resume_workyear; //工作经验
    private String resume_intro;    //简介

    public Resume() {
    }

    public Resume(Integer resume_id) {
        this.resume_id = resume_id;
    }

    public Resume(String resume_designation, Integer resume_user_id, String resume_name, String resume_sex, Integer resume_age, String resume_phone, String resume_education, String resume_school, String resume_major, Integer resume_workyear, String resume_intro) {
        this.resume_designation = resume_designation;
        this.resume_user_id = resume_user_id;
        this.resume_name = resume_name;
        this.resume_sex = resume_sex;
        this.resume_age = resume_age;
        this.resume_phone = resume_phone;
        this.resume_education = resume_education;
        this.resume_school = resume_school;
        this.resume_major = resume_major;
        this.resume_workyear = resume_workyear;
        this.resume_intro = resume_intro;
    }

    public Integer getResume_id() {
        return resume_id;
    }

    public void setResume_id(Integer resume_id) {
        this.resume_id = resume_id;
    }

    public String getResume_designation() {
        return resume_designation;
    }

    public void setResume_designation(String resume_designation) {
        this.resume_designation = resume_designation;
    }

    public Integer getResume_user_id() {
        return resume_user_id;
    }

    public void setResume_user_id(Integer resume_user_id) {
        this.resume_user_id = resume_user_id;
    }

    public String getResume_name() {
        return resume_name;
    }

    public void setResume_name(String resume_name) {
        this.resume_name = resume_name;
    }

    public String getResume_sex() {
        return resume_sex;
    }

    public void setResume_sex(String resume_sex) {
        this.resume_sex = resume_sex;
    }

    public Integer getResume_age() {
        return resume_age;
    }

    public void setResume_age(Integer resume_age) {
        this.resume_age = resume_age;
    }

    public String getResume_phone() {
        return resume_phone;
    }

    public void setResume_phone(String resume_phone) {
        this.resume_phone = resume_phone;
    }

    public String getResume_education() {
        return resume_education;
    }

    public void setResume_education(String resume_education) {
        this.resume_education = resume_education;
    }

    public String getResume_school() {
        return resume_school;
    }

    public void setResume_school(String resume_school) {
        this.resume_school = resume_school;
    }

    public String getResume_major() {
        return resume_major;
    }

    public void setResume_major(String resume_major) {
        this.resume_major = resume_major;
    }

    public Integer getResume_workyear() {
        return resume_workyear;
    }

    public void setResume_workyear(Integer resume_workyear) {
        this.resume_workyear = resume_workyear;
    }

    public String getResume_intro() {
        return resume_intro;
    }

    public void setResume_intro(String resume_intro) {
        this.resume_intro = resume_intro;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "resume_id=" + resume_id +
                ", resume_designation='" + resume_designation + '\'' +
                ", resume_user_id=" + resume_user_id +
                ", resume_name='" + resume_name + '\'' +
                ", resume_sex='" + resume_sex + '\'' +
                ", resume_age=" + resume_age +
                ", resume_phone='" + resume_phone + '\'' +
                ", resume_education='" + resume_education + '\'' +
                ", resume_school='" + resume_school + '\'' +
                ", resume_major='" + resume_major + '\'' +
                ", resume_workyear=" + resume_workyear +
                ", resume_intro='" + resume_intro + '\'' +
                '}';
    }
}
