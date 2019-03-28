package com.java.util;

import java.util.ArrayList;
import java.util.List;

public class NBA {
    public static void main(String[] args) {
        List<Mulu> list = new ArrayList<>();
        list.add(new Mulu("乔丹","飞人/神","30.1","6.2","5.3"));
        list.add(new Mulu("拉塞尔","指环王","15.1","22.5","4.3"));
        int length =list.size();
        System.out.println("-------------NBA历史两大巨星-------------");
        System.out.println("球员  绰号  得分  篮板  助攻");
        for (int i = 0;i<length;i++){
            System.out.println(list.get(i).getName() + " " + list.get(i).getChuohao() + " " + list.get(i).getDefen()+" "+list.get(i).getLanban()+" "+list.get(i).getZhugong());

        }
    }
}
