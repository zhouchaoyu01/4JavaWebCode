package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author ChanceZhou
 * @create 2021-12-07-12:03
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null, "javaeee", 1, new BigDecimal(99), new BigDecimal(99), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javase", 1, new BigDecimal(99), new BigDecimal(99), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javaweb", 1, new BigDecimal(99), new BigDecimal(99), "1234567890"));
    }
}