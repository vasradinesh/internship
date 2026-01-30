//Program to count the number of key-value (size) mappings in a map.


import java.util.*;;

public class Practice03 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "thre");
        map.put(4, "four");

        System.out.println(map.size());
    }
}
