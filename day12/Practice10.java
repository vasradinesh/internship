// Write a Java program to find the second smallest and largest elements in a list of integers using streams.

import java.util.Arrays;
import java.util.*;

public class Practice10 {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,3,2,4,7,3,8);
        int secondsmall = l.stream().sorted((a,b)->a-b).skip(1).findFirst().orElse(-1);
        int secondlarge = l.stream().sorted((a,b)->b-a).skip(1).findFirst().orElse(-1);

        System.out.println("secondsmall : " + secondsmall);
        System.out.println("secondlarge : " + secondlarge);

    }
}
