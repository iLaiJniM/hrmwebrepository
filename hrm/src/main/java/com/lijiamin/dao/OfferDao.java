package com.lijiamin.dao;

import com.lijiamin.model.Interview;
import com.lijiamin.model.Offer;

import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
public interface OfferDao {
    Integer insertOffer(Offer offer);    //��¼��֪ͨ
    Offer queryOfferByOffer_id(Integer offer_id);   //����¼��֪ͨid��¼��֪ͨ
    List<Offer> queryOfferByOffer_user_id(Integer offer_user_id);  //�����û�id��¼��֪ͨ����
}
