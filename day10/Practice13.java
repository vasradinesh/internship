//Program to implement a lambda expression to find the second largest and smallest element in an array.

import java.util.Arrays;
import java.util.List;

public class Practice13 {
    public static void main(String[] args) {
        List<Integer> var1 = Arrays.asList(1,3,5,78,5);
        int secondlarge = var1.stream().distinct().sorted().skip(1).findFirst().get();
        int secondsmall = var1.stream().distinct().sorted((a,b)-> b - a).skip(1).findFirst().get();
        System.out.println("secondsmall : "+ secondsmall);
        System.out.println("secondlarge : "+ secondlarge);
    }
}
