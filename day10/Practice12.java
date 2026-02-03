//Program to implement a lambda expression to find the length of the longest and smallest string in a list.

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practice12 {
    public static void main(String[] args) {
         List<String> var1 = Arrays.asList("dineshvasra", "kartik", "don", "donkey");

         Comparator<String> length = (a,b) -> {return a.length() - b.length();};
         System.out.println("max length : " + (Collections.max(var1,length)).length());
         System.out.println("min length : " + (Collections.min(var1,length)).length());

    }
}
