package com.java.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class ArticleListTest {
    public static void main(String[] args) throws ParseException {
        //创建集合对象
        List<Article> list = new ArrayList<>();
        //SimpleDateFormat格式化日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //向集合添加元素
        list.add(new Article(1, "《亲爱的安德烈》《孩子你慢慢来》", "龙应台", simpleDateFormat.parse("2019-03-12 22:13:22")));
        list.add(new Article(2, "《得未曾有》《月童渡河》《莲花》", "安妮宝贝", simpleDateFormat.parse("2019-02-13 22:13:22")));
        list.add(new Article(3, "《白夜行》《嫌疑人x的献身》", "东野圭吾", simpleDateFormat.parse("2019-02-14 22:13:22")));

        System.out.println("id    标题                 作者    时间");
        //用Iterator迭代器输出Article
        Iterator<Article> iterator = list.iterator();
        while (iterator.hasNext()) {
            Article article = iterator.next();
            String result;
            result = timeCal(simpleDateFormat.format(article.getTime()));
            //当title大于10个字符时，省略后部
            System.out.println(article.getId() + "  " + article.getTitle().substring(0, 10) + "..." +
                    article.getAuthor() + "  " + result);
        }
    }

    private static String timeCal(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1;
        long diff = 0;
        try {
            d1 = format.parse(time);
            Date now = new Date();
            diff = now.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        if (seconds < 60) {
            return "刚刚";
        } else if (minutes < 60) {
            return minutes + "分钟前";
        } else if (hours < 24) {
            return hours + "小时前";
        } else {
            return days + "天前";
        }
    }


}
