//Program to implement a lambda expression to remove duplicates from a list of integers.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice06 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,5,4,1,3,4,5);
        List<Integer> list2 = list.stream().distinct().collect(Collectors.toList());

        System.out.println(list2);
    }
}
