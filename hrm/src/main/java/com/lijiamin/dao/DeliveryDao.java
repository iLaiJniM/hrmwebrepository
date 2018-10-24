package com.lijiamin.dao;

import com.lijiamin.model.Delivery;

import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
public interface DeliveryDao {
    Integer insertDelivery(Delivery delivery);    //��Ͷ��
    Integer deleteDelivery(Integer delivery_id);    //ɾͶ��
    Integer updateDelivery(Delivery delivery);    //��Ͷ��
    Delivery queryDelivery(Delivery delivery);   //��Ͷ��
    List<Delivery> queryDeliveryAll();  //������Ͷ��
}
