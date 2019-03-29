package soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        System.out.println(set);
/*        String s1 = new String("a");
        String s2 = new String("b");
        String s3 = new String("c");
        String s4 = new String("a");
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        System.out.println(set);*/
        //用for循环遍历set集合
        System.out.println("for循环遍历结果");
        Object[] array = set.toArray();
        for (int i = 0, len = set.size(); i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        //用Iterator迭代器便里set集合
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("");
        //用Lambda表达式遍历set集合
        set.forEach(s -> System.out.print(s + " "));
    }
}
