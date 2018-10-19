package com.lijiamin.service;

import com.lijiamin.model.User;

/**
 * Created by 31543 on 2018/10/19.
 */
public interface UserService {
    Boolean insertUser(User user);
    User queryUser(User user);
}
