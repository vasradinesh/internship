//Program to check whether a map contains key-value mappings (empty) or not

import java.util.*;

public class Practice04 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        if (map.isEmpty()) {
            System.out.println("Map is empty");
        } else {
            System.out.println("Map is not empty");
        }
    }
}
