package soft1841.list;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"java",23.3));
        list.add(new Book(2,"math",24.3));
        list.add(new Book(3,"HTML",25.1));
        System.out.println(list);
        list.add(new Book(2,"English",23));
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.set(2,new Book(3,"math",98.34));
        System.out.println(list);
        System.out.println(list.get(1));
        list.add(new Book(2,"MM",33));
        System.out.println(list);
        System.out.println(list.indexOf("English"));
        System.out.println(list.lastIndexOf("MM"));

    }
}
