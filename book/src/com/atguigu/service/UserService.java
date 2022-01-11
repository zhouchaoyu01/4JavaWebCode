package com.atguigu.service;

import com.atguigu.pojo.User;

/**
 * @author ChanceZhou
 * @create 2021-11-06-9:10
 */
public interface UserService {
    /**
     * 注册
     *
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登陆
     *
     * @param user
     * @return 如果返回null，说明登录失败
     */
    public User loginUser(User user);

    /**
     * 检测用户名是否存在
     *
     * @param username
     * @return true 存在  false 可以使用
     */
    public boolean existsUsername(String username);
}
