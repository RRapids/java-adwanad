package com.java.util;

import java.util.Stack;

/**
 * Integer类的练习
 *
 * @author 79876
 * 2019.3.12
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //将字符串转换为int类型
        int num = Integer.parseInt("456");
        //通过构造函数创建一个Integer对象
        Integer iNum = Integer.valueOf("456");
        System.out.println("int数据与Integer对象的比较");
        //获取数字的二进制表示
        String str2 = Integer.toBinaryString(num);
        //获取数字的十六进制表示
        String str3 = Integer.toHexString(num);
        //获取数字的八进制表示
        String str4 = Integer.toOctalString(num);
        //获取数字的十五进制表示
        String str5 = Integer.toString(num, 15);
        System.out.println("456二进制表示为：" + str2);
        System.out.println("456十六进制表示为：" + str3);
        System.out.println("456八进制表示为：" + str4);
        System.out.println("456十五进制表示为：" + str5);
        System.out.println("------------分割线-------------");
        System.out.println("456转化7进制：" + convert(num, 7));

    }

    private static String convert(int num, int radix) {
        //创建一个StringBuffer，用来存放结果字符串
        StringBuffer stringBuffer = new StringBuffer();
        //被除数不为0
        while (num != 0) {
            //求出余数
            int remainder = num % radix;
            //将余数加入stringBuffer
            stringBuffer.append(String.valueOf(remainder));
            //更新被除数为商
            num = num / radix;
        }
        //将结果串取返回
        return stringBuffer.reverse().toString();
    }
}
