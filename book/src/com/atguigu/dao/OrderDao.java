package com.atguigu.dao;

import com.atguigu.pojo.Order;

/**
 * @author ChanceZhou
 * @create 2021-12-07-10:30
 */
public interface OrderDao {
    public int saveOrder(Order order);
}
