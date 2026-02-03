//Program to implement a lambda expression to check if a list of strings contains a specific word.

import java.util.Arrays;
import java.util.List;


interface hasA {
    boolean hasAstring(String n , List<String> l);
} 

public class Practice11 {
    public static void main(String[] args) {
    List<String> list = Arrays.asList("dinesh","kartik","don","donkey");
    hasA h =(a,l) -> l.contains(a);

    System.out.println(h.hasAstring("dinesh", list));
        
    }
}
