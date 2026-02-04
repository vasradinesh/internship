//Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice08 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("car" ,"bike","bmw","activa","a","z","aa");  

        List<String> acs = list.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
        List<String> des = list.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());

        System.out.println("in ascending : " + acs);
        System.out.println("in descending : " + des);
        
    }
}
