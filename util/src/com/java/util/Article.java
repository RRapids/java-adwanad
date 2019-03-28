package com.java.util;

import java.util.Date;

/**
 *
 */
public class Article {
    public Integer id;
    public String title;
    public String author;
    public Date time;

    public Article(Integer id, String title, String author, Date time) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
