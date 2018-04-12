package com.book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jayapal_uradi on 8/10/17.
 */
public class BookShop {

    public String shopName;
    public List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void loadData() {
        for (int i=0; i< 6; i++) {
            Book b = new Book();
            b.setBookId(i);
            b.setBookName("book-"+i);
            getBooks().add(b);
        }

    }

    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }
}
