package com.soft1841.week4;

import com.java.util.Book;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookList {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("java", 66.6));
        bookList.add(new Book("java", 66.6));
        bookList.add(new Book("java", 66.6));
        System.out.println("------图书信息------");
        System.out.println("书名        价格");
        for (int i = 0, length = bookList.size(); i < length; i++) {
            System.out.println(bookList.get(i).getName() + "    " + bookList.get(i).getPrice());
            System.out.println();
        }

        System.out.println("用Iterator迭代器输出结果");
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getName() + "   " + book.getPrice());
        }

        System.out.println("Lambda表达式遍历输出结果");
        bookList.forEach(book -> System.out.println(book.getName() + "   " + book.getPrice()));
    }
}