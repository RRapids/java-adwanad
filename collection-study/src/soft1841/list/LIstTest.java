package soft1841.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LIstTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //2.通过for循环遍历集合
        for (int i = 0, len = list.size(); i < len; i++) {
            System.out.println(list.get(i));
        }
        //3.通过Iterator迭代器遍历集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //4.通过Lambda表达式遍历集合
        list.forEach(s -> System.out.println(s));
    }
}
