package com.atguigu.dao;

import com.atguigu.pojo.User;

/**
 * @author ChanceZhou
 * @create 2021-11-06-8:22
 */
public interface UserDao {

    //选中接口， Navigate -> Test 快速生成Test

    /**
     * 根据用户名查用户信息
     *
     * @param username
     * @return null 无用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查用户信息
     *
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return 返回-1 表示操作失败
     */
    public int saveUser(User user);


}
