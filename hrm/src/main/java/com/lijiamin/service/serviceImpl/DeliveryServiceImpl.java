package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.DeliveryDao;
import com.lijiamin.model.Delivery;
import com.lijiamin.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 31543 on 2018/10/24.
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryDao deliveryDao;

    public boolean insertDelivery(Delivery delivery) {
        if(null != delivery){
            Integer i = deliveryDao.insertDelivery(delivery);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public boolean deleteDelivery(Integer delivery_id) {
        if(null != delivery_id && delivery_id > 0){
            Integer i = deliveryDao.deleteDelivery(delivery_id);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public boolean updateDelivery(Delivery delivery) {
        if(null != delivery){
            Integer i = deliveryDao.updateDelivery(delivery);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Delivery queryDelivery(Integer delivery_id) {
        if(null != delivery_id && delivery_id > 0){
            return deliveryDao.queryDelivery(delivery_id);
        }
        return null;
    }

    public List<Delivery> queryDeliveryByDelivery_recruit_id(Integer delivery_recruit_id) {
        if(null != delivery_recruit_id && delivery_recruit_id > 0){
            List<Delivery> deliveryList = deliveryDao.queryDeliveryByDelivery_recruit_id(delivery_recruit_id);
            if(null != deliveryList && deliveryList.size() >= 0){
                return deliveryList;
            }
        }
        return null;
    }
}
