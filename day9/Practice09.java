//Program to search for a value in a Tree Map.

import java.util.*;

public class Practice09 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "thre");
        map.put(4, "four");

        if (map.containsValue("one")) {
            System.out.println("Map has that value");
        } else {
            System.out.println("Map not has that value");
        }
    }
}
