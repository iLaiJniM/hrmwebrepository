package com.lijiamin.service;

import com.lijiamin.model.Delivery;

import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
public interface DeliveryService {
    boolean insertDelivery(Delivery delivery);    //添投递
    boolean deleteDelivery(Integer delivery_id);    //删投递
    boolean updateDelivery(Delivery delivery);    //改投递
    Delivery queryDelivery(Integer delivery_id);   //查投递
    List<Delivery> queryDeliveryByDelivery_recruit_id(Integer delivery_recruit_id);  //根据delivery_recruit_id查投递
}
