//Write a Java program to remove all duplicate elements from a list using streams.

import java.util.*;
import java.util.stream.Collectors;

public class Practice06 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4,2,8,5,1,3,4,5);

        List<Integer>  distinctlist= list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctlist);
    }
}
