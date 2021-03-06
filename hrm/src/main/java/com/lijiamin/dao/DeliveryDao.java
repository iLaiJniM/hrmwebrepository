package com.lijiamin.dao;

import com.lijiamin.model.Delivery;

import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
public interface DeliveryDao {
    Integer insertDelivery(Delivery delivery);    //添投递
    Integer deleteDelivery(Integer delivery_id);    //删投递
    Integer updateDelivery(Delivery delivery);    //改投递
    Delivery queryDelivery(Integer delivery_id);   //查投递
    List<Delivery> queryDeliveryByDelivery_recruit_id(Integer delivery_recruit_id);  //根据delivery_recruit_id查投递
}
