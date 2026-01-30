//Program to delete all elements from a Tree Map.

import java.util.TreeMap;

public class Practice10 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(565, "oo");
        map.put(64, "qq");
        map.put(33, "aa");
        map.put(66, "gg");

        System.out.println("before clear map - " + map);
        map.clear();
        System.out.println("after clear map - " + map);
        
    }
}
