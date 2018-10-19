package com.lijiamin.dao;

import com.lijiamin.model.User;

/**
 * Created by 31543 on 2018/10/19.
 */
public interface UserDao {
    Integer insertUser(User user);
    User queryUser(User user);
}
