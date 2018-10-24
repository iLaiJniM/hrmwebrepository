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
    Delivery queryDelivery(Delivery delivery);   //查投递
    List<Delivery> queryDeliveryAll();  //查所有投递
}
