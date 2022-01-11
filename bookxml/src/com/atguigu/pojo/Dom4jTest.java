package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author ChanceZhou
 * @create 2021-10-21-22:03
 */
public class Dom4jTest {

    @Test
    public void test() throws DocumentException {

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("src/books.xml");

            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
        System.out.println("****************************");
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
//            System.out.println(book.asXML());
            Element nameElement = book.element("name");
            String nameText = nameElement.getText();
//            System.out.println(nameText);


            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            String snValue = book.attributeValue("sn");
//            System.out.println(priceText);
            Book bk = new Book();
            bk.setAuthor(authorText);
            bk.setName(nameText);
            bk.setPrice(Double.parseDouble(priceText));
            bk.setSn(snValue);
            System.out.println(bk);


        }


    }

}
