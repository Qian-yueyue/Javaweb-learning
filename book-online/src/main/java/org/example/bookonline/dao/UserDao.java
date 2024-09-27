package org.example.bookonline.dao;

import org.example.bookonline.entity.User;

public interface UserDao {

    int insertUser(User user);      //    command+shirt+T
    User findUser(User user);
}
