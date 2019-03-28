package com.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTest {
    public static void main(String[] args) {
        //创建一个List接口的对象，元素为String类型
        List<String> list = new ArrayList<>();
        //增加三个元素
        list.add("java");
        list.add("HTML");
        list.add("math");
        list.add("math");
        //用util的Random类随机产出一个[0,list.size（）-]的随机数
        int length = list.size();
        Random random = new Random();
        int index = random.nextInt(length);
        //取出list中索引为index的元素
        System.out.println(index);
        System.out.println(list.get(index));
        System.out.println("******************");
        //用for循环输出所用元素
        for (int i = 0;i<length;i++){
            System.out.println(list.get(i));
        }
    }
}
