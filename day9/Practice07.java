//Program to get a shallow copy of a HashMap instance.

import java.util.HashMap;

public class Practice07 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "thre");
        map.put(4, "four");

        HashMap<Integer,String> map2 = new HashMap<>(map);
        System.out.println(map2);
    }
}
