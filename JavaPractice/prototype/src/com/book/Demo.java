package com.book;

/**
 * Created by jayapal_uradi on 8/10/17.
 */
public class Demo {

    public static void main(String args[]) {

        System.out.println("This is prototype example");

        BookShop b1 = new BookShop();
        b1.setShopName("ShopOne");
        b1.loadData();
        System.out.println(b1);

        BookShop b2 = new BookShop();


        b2 = b1;
        b2.setShopName("Shop2");
        b2.setBooks(b1.getBooks());
        System.out.println(b2);

    }
}
