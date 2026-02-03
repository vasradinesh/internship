//Program to implement a lambda expression to find the average length of strings in a list.

import java.util.*;

public class Practice14 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "kiwi", "strawberry");

        double averageLength = list.stream()
                                   .mapToInt(s -> s.length())  
                                   .average()
                                   .orElse(0);

        System.out.println("Average length of strings: " + averageLength);
    }
}