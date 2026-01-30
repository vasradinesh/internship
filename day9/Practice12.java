//Program to get the portion of a map whose keys are strictly less than a given key.

import java.util.Map;
import java.util.TreeMap;

public class Practice12 {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(10, "Apple");
        map.put(20, "Banana");
        map.put(30, "Cherry");
        map.put(40, "Date");

        Map<Integer, String> result = map.headMap(30);

        System.out.println("Original TreeMap: " + map);
        System.out.println("Keys strictly less than " + 30 + ": " + result);


    }
}
