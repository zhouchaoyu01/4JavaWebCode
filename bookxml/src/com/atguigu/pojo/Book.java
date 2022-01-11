package com.atguigu.pojo;

import java.math.BigDecimal;

/**
 * @author ChanceZhou
 * @create 2021-10-21-21:57
 */
public class Book {
    private String sn;
    private String name;
    private double price;
    private String author;

    public Book() {
    }

    public Book(String snValue, String nameText, double parseDouble, String authorText) {
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
