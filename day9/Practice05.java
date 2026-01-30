//Program to test if a map contains a mapping for the specified value.

import java.util.HashMap;

public class Practice05 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "thre");
        map.put(4, "four");

        if (map.containsKey(1)) {
            System.out.println("Map has that key");
        } else {
            System.out.println("Map not has that key");
        }
    }
}
