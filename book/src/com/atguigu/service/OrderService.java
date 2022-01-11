package com.atguigu.service;

import com.atguigu.pojo.Cart;

/**
 * @author ChanceZhou
 * @create 2021-12-07-12:10
 */
public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
