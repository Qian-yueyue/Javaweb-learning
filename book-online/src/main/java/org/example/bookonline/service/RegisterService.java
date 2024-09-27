package org.example.bookonline.service;

import org.example.bookonline.entity.User;

public interface RegisterService {
    /**
     * 用户注册功能
     *
     * @param account  账号
     * @param password 密码
     * @param nickname 昵称
     * @param avatar 头像
     * @param address 地址
     * @return user
     */
    User registerIn(String account, String password,String nickname,String avatar,String address);

}
