package Daka;

import java.text.SimpleDateFormat;

public class Date {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String dateString = sdf.format(date);
        System.out.println(dateString);
    }
}
