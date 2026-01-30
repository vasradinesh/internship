//Program to get a set view of the keys contained in this map.

import java.util.*;

public class Practice06 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "thre");
        map.put(4, "four");

        Set s =map.keySet();
        System.out.println(s);
    }
}
