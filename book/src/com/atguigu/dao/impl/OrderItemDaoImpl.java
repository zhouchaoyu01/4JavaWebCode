package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

/**
 * @author ChanceZhou
 * @create 2021-12-07-10:42
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {


    @Override
    public int saveOrderItem(OrderItem orderItem) {
        System.out.println("OrderItemDaoImpl当前线程名 ：" + Thread.currentThread().getName());
        String sql = "insert into t_order_item(`name`,`count` ,`price`,`total_price`,`order_id`)values(?,?,?,?,?)";
        return update(sql,  orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
