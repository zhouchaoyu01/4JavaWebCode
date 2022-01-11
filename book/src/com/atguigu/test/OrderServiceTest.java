package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author ChanceZhou
 * @create 2021-12-07-12:29
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));


        OrderServiceImpl orderService = new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart, 1));

    }
}