package com.lijiamin.service.serviceImpl;

import com.lijiamin.dao.UserDao;
import com.lijiamin.model.User;
import com.lijiamin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 31543 on 2018/10/19.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public Boolean insertUser(User user) {
        if(user != null){
            User user1 = new User(user.getUser_name());
            if(userDao.queryUser(user1) == null){
                Integer i = userDao.insertUser(user);
                if(i != null && i >0 ){
                    return true;
                }
            }
        }
        return false;
    }

    public User queryUser(User user) {
        if (user != null) {
            if (userDao.queryUser(user) != null) {
                return userDao.queryUser(user);
            }
        }
        return null;
    }
}
