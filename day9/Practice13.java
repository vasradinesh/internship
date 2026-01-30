//Program to get a key-value mapping associated with the greatest key strictly less than the given key. Return null if there is no such key.

import java.util.TreeMap;

public class Practice13 {
    public static void main(String[] args) {
        TreeMap map = new TreeMap();

        map.put(10, "Apple");
        map.put(20, "Banana");
        map.put(30, "Cherry");
        map.put(40, "Date");

        System.out.println(map.lowerEntry(20));
    }
}
