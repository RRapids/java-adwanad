package Daka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 实现Comparable接口的Juice，放入List进行按年龄排序
 *
 * @author 腾飞
 * 2019.3.20
 */
public class JuiceList {
    public static void main(String[] args) {
        //创建List对象，存入Juice对象
        List<Juice> list = new ArrayList<>();
        list.add(new Juice("冰红茶", 3));
        list.add(new Juice("脉动", 4));
        list.add(new Juice("红牛", 6));
        list.add(new Juice("椰汁", 10));
        //调用Collections的方法，会自动调用之前写的compareTo方法进行排序
        Collections.sort(list);
        //用foreach循环遍历list
        for (Juice juice : list) {
            System.out.println("饮料名：" + juice.getName() + ",价格：" + juice.getPrice());
        }
    }
}
