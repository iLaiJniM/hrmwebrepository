package com.lijiamin.model;

import java.io.Serializable;

/**
 * Created by 31543 on 2018/10/23.
 */
public class Position implements Serializable {
    private Integer position_id;
    private String position_name;
    private String position_createtime;
    private Integer position_department_id;

    public Position() {
    }

    public Position(Integer position_id) {
        this.position_id = position_id;
    }

    public Position(String position_name) {
        this.position_name = position_name;
    }

    public Position(String position_name, String position_createtime, Integer position_department_id) {
        this.position_name = position_name;
        this.position_createtime = position_createtime;
        this.position_department_id = position_department_id;
    }

    public Integer getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Integer position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPosition_createtime() {
        return position_createtime;
    }

    public void setPosition_createtime(String position_createtime) {
        this.position_createtime = position_createtime;
    }

    public Integer getPosition_department_id() {
        return position_department_id;
    }

    public void setPosition_department_id(Integer position_department_id) {
        this.position_department_id = position_department_id;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position_id=" + position_id +
                ", position_name='" + position_name + '\'' +
                ", position_createtime='" + position_createtime + '\'' +
                ", position_department_id=" + position_department_id +
                '}';
    }
}
