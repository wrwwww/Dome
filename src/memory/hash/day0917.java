package memory.hash;

import java.util.HashMap;

public class day0917 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1000000, "我是1000000");
        map.put(2, "我是2");
        map.put(3, "我是3");
        map.put(4, "我是4");
        map.put(5, "我是5");
        map.put(6, "我是6");
        map.put(1000000, "我是1000001");

        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(2));

        System.out.println(map.get(4));
        System.out.println(map.get(10));

        map.put(4, "他是4");
        System.out.println(map.get(4));

        map.remove(4);
        System.out.println(map.get(4));

    }
}
