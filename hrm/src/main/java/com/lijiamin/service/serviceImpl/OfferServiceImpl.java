package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.OfferDao;
import com.lijiamin.model.Offer;
import com.lijiamin.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 31543 on 2018/10/25.
 */
@Service
public class OfferServiceImpl implements OfferService{
    @Autowired
    private OfferDao offerDao;

    public boolean insertOffer(Offer offer) {
        if(null != offer){
            Integer i = offerDao.insertOffer(offer);
            if(i != null && i > 0 ){
                return true;
            }
        }
        return false;
    }

    public Offer queryOfferByOffer_id(Integer offer_id) {
        if(null != offer_id && offer_id > 0) {
            return offerDao.queryOfferByOffer_id(offer_id);
        }
        return null;
    }

    public List<Offer> queryOfferByOffer_user_id(Integer offer_user_id) {
        if(null != offer_user_id && offer_user_id > 0) {
            List<Offer> offerList = offerDao.queryOfferByOffer_user_id(offer_user_id);
            if (offerList.size() > 0) {
                return offerList;
            }
        }
        return null;
    }
}
