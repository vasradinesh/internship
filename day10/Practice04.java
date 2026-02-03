// Program to implement a lambda expression to filter out even and odd numbers from a list of integers

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Practice04 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        Predicate<Integer> iseven = s-> s%2==0;
        Predicate<Integer> isODD = s-> s%2!=0;


        List<Integer> seven = list.stream()
                                .filter(iseven)
                                .collect(Collectors.toList());
        List<Integer> sodd = list.stream()
                                .filter(isODD)
                                .collect(Collectors.toList());

        System.out.println("odd by stream API: " + sodd);
        System.out.println("even by stream API: " + seven);

        list.forEach(s -> {
            if(s%2 == 0){
                even.add(s);
            }else{
                odd.add(s);
            }
        });

        System.out.println("odd : " + odd);
        System.out.println("even : " + even);
    }
}
