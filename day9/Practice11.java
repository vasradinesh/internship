//Program to get a key-value mapping associated with the greatest key and the least key in a map.

import java.util.*;

public class Practice11 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(565, "oo");
        map.put(64, "qq");
        map.put(33, "aa");
        map.put(66, "gg");

        System.out.println("greatest " + map.firstKey());
        System.out.println("greatest " + map.lastKey());
    }
}
