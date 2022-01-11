package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author ChanceZhou
 * @create 2021-12-04-9:15
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.clear();
        System.out.println(cart);
    }

    @Test

    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "c", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.clear();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.updateCount(1, 20);
        System.out.println(cart);
    }
}