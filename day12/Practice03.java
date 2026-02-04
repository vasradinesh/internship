
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;


//Write a Java program to calculate the average of a list of integers using streams.

public class Practice03 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4,2,8,5);

        double average = list.stream().mapToInt(i->i).average().orElse(0.0);
        System.out.println("average : " + average);
        
    }
}
