package org.example.bookonline.dao;

import org.example.bookonline.dao.impl.UserDaoImpl;
import org.example.bookonline.entity.User;
import org.junit.jupiter.api.Test;

class UserDaoTest {

    @Test
    void insertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = User.builder().account("qqq").nickname("qyy").password("123456").address("江苏南京").
                avatar("https://tse3-mm.cn.bing.net/th/id/OIP-C.B-I4hghhuJB4za-I2L5bdAHaHa?rs=1&pid=ImgDetMain").build();
        userDao.insertUser(user);
    }
}