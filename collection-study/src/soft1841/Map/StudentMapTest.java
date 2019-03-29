package soft1841.Map;

import java.util.*;

public class StudentMapTest {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(1, "张三"));
        list1.add(new Student(2, "小明"));
        list1.add(new Student(3, "小王"));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(4, "小红"));
        list2.add(new Student(5, "小兰"));

        Map<String, List<Student>> map = new HashMap<>();
        map.put("男生", list1);
        map.put("女生", list2);
        System.out.println("********按性别输出结果********");
        Iterator<Map.Entry<String, List<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Student>> entry = iterator.next();
            System.out.println(entry.getKey());
            List<Student> list = entry.getValue();
            for (Student s : list) {
                System.out.println(s.getID() + s.getName());
                System.out.println();
            }
        }
    }
}
