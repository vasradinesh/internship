//Program to copy Tree Map's content to another Tree Map.

import java.util.*;

public class Practice08 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "thre");
        map.put(4, "four");

        TreeMap<Integer,String> map2 = new TreeMap<>(map);
        System.out.println(map2);
    }
}
