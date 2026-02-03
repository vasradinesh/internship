//Program to implement a lambda expression to sort a list of strings in alphabetical order.

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice05 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("vdinesh","kartik","ydon","donkey");

        Collections.sort(list, (a,b) -> a.compareTo(b));
        System.out.println(list);
        
    }
}
