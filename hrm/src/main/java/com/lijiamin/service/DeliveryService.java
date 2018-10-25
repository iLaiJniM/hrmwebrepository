package com.lijiamin.service;

import com.lijiamin.model.Delivery;

import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
public interface DeliveryService {
    boolean insertDelivery(Delivery delivery);    //��Ͷ��
    boolean deleteDelivery(Integer delivery_id);    //ɾͶ��
    boolean updateDelivery(Delivery delivery);    //��Ͷ��
    Delivery queryDelivery(Integer delivery_id);   //��Ͷ��
    List<Delivery> queryDeliveryByDelivery_recruit_id(Integer delivery_recruit_id);  //����delivery_recruit_id��Ͷ��
}
