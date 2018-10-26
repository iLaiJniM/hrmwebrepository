package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/25.
 */
public class Interview implements Serializable {
    private Integer interview_id;   //��������id
    private String interview_time;   //��������ʱ��
    private String interview_place;   //��������ص�
    private Integer interview_user_id;   //���������û�id
    private Integer interview_state;    //��������״̬��0�����ԣ�Ĭ�ϣ���1Ϊȷ������
    private Integer interview_resume_id;  //����id
    private String interview_date; //������������
    private Integer interview_recruit_id; //ӦƸid
    private String interview_recruit_departname;    //ӦƸ����
    private String interview_recruit_positionname;    //ӦƸְλ
    private String interview_resume_name;   //������

    public Interview() {
    }

    public Interview(String interview_time, String interview_place, Integer interview_user_id, Integer interview_state, Integer interview_resume_id, String interview_date, Integer interview_recruit_id, String interview_recruit_departname, String interview_recruit_positionname, String interview_resume_name) {
        this.interview_time = interview_time;
        this.interview_place = interview_place;
        this.interview_user_id = interview_user_id;
        this.interview_state = interview_state;
        this.interview_resume_id = interview_resume_id;
        this.interview_date = interview_date;
        this.interview_recruit_id = interview_recruit_id;
        this.interview_recruit_departname = interview_recruit_departname;
        this.interview_recruit_positionname = interview_recruit_positionname;
        this.interview_resume_name = interview_resume_name;
    }

    public Integer getInterview_id() {
        return interview_id;
    }

    public void setInterview_id(Integer interview_id) {
        this.interview_id = interview_id;
    }

    public String getInterview_time() {
        return interview_time;
    }

    public void setInterview_time(String interview_time) {
        this.interview_time = interview_time;
    }

    public String getInterview_place() {
        return interview_place;
    }

    public void setInterview_place(String interview_place) {
        this.interview_place = interview_place;
    }

    public Integer getInterview_user_id() {
        return interview_user_id;
    }

    public void setInterview_user_id(Integer interview_user_id) {
        this.interview_user_id = interview_user_id;
    }

    public Integer getInterview_state() {
        return interview_state;
    }

    public void setInterview_state(Integer interview_state) {
        this.interview_state = interview_state;
    }

    public Integer getInterview_resume_id() {
        return interview_resume_id;
    }

    public void setInterview_resume_id(Integer interview_resume_id) {
        this.interview_resume_id = interview_resume_id;
    }

    public String getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(String interview_date) {
        this.interview_date = interview_date;
    }

    public Integer getInterview_recruit_id() {
        return interview_recruit_id;
    }

    public void setInterview_recruit_id(Integer interview_recruit_id) {
        this.interview_recruit_id = interview_recruit_id;
    }

    public String getInterview_recruit_departname() {
        return interview_recruit_departname;
    }

    public void setInterview_recruit_departname(String interview_recruit_departname) {
        this.interview_recruit_departname = interview_recruit_departname;
    }

    public String getInterview_recruit_positionname() {
        return interview_recruit_positionname;
    }

    public void setInterview_recruit_positionname(String interview_recruit_positionname) {
        this.interview_recruit_positionname = interview_recruit_positionname;
    }

    public String getInterview_resume_name() {
        return interview_resume_name;
    }

    public void setInterview_resume_name(String interview_resume_name) {
        this.interview_resume_name = interview_resume_name;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "interview_id=" + interview_id +
                ", interview_time='" + interview_time + '\'' +
                ", interview_place='" + interview_place + '\'' +
                ", interview_user_id=" + interview_user_id +
                ", interview_state=" + interview_state +
                ", interview_resume_id=" + interview_resume_id +
                ", interview_date='" + interview_date + '\'' +
                ", interview_recruit_id=" + interview_recruit_id +
                ", interview_recruit_departname='" + interview_recruit_departname + '\'' +
                ", interview_recruit_positionname='" + interview_recruit_positionname + '\'' +
                ", interview_resume_name='" + interview_resume_name + '\'' +
                '}';
    }
}
