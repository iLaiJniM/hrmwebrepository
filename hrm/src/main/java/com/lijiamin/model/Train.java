package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/27.
 */
public class Train implements Serializable {
    private Integer train_id;   //培训id
    private String train_theme;   //主题
    private String train_content;   //具体内容
    private Integer train_employee_id;   //对象
    private String train_starttime;   //开始时间
    private String train_endtime;   //结束时间
    private String train_place;   //地点

    public Train() {
    }

    public Train(Integer train_employee_id) {
        this.train_employee_id = train_employee_id;
    }

    public Train(String train_theme, String train_content, Integer train_employee_id, String train_starttime, String train_endtime, String train_place) {
        this.train_theme = train_theme;
        this.train_content = train_content;
        this.train_employee_id = train_employee_id;
        this.train_starttime = train_starttime;
        this.train_endtime = train_endtime;
        this.train_place = train_place;
    }

    public Integer getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Integer train_id) {
        this.train_id = train_id;
    }

    public String getTrain_theme() {
        return train_theme;
    }

    public void setTrain_theme(String train_theme) {
        this.train_theme = train_theme;
    }

    public String getTrain_content() {
        return train_content;
    }

    public void setTrain_content(String train_content) {
        this.train_content = train_content;
    }

    public Integer getTrain_employee_id() {
        return train_employee_id;
    }

    public void setTrain_employee_id(Integer train_employee_id) {
        this.train_employee_id = train_employee_id;
    }

    public String getTrain_starttime() {
        return train_starttime;
    }

    public void setTrain_starttime(String train_starttime) {
        this.train_starttime = train_starttime;
    }

    public String getTrain_endtime() {
        return train_endtime;
    }

    public void setTrain_endtime(String train_endtime) {
        this.train_endtime = train_endtime;
    }

    public String getTrain_place() {
        return train_place;
    }

    public void setTrain_place(String train_place) {
        this.train_place = train_place;
    }

    @Override
    public String toString() {
        return "Train{" +
                "train_id=" + train_id +
                ", train_theme='" + train_theme + '\'' +
                ", train_content='" + train_content + '\'' +
                ", train_employee_id=" + train_employee_id +
                ", train_starttime='" + train_starttime + '\'' +
                ", train_endtime='" + train_endtime + '\'' +
                ", train_place='" + train_place + '\'' +
                '}';
    }
}
