package com.lijiamin.dao;

import com.lijiamin.model.Interview;
import com.lijiamin.model.Offer;

import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
public interface OfferDao {
    Integer insertOffer(Offer offer);    //添录用通知
    Offer queryOfferByOffer_id(Integer offer_id);   //根据录用通知id查录用通知
    List<Offer> queryOfferByOffer_user_id(Integer offer_user_id);  //根据用户id查录用通知集合
}
