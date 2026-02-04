
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Write a Java program to find the maximum and minimum values in a list of integers using streams.

public class Practice09 {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,3,2,4,7,3,8);

        int max = l.stream().max((a,b) -> a-b).get();
        int min = l.stream().min((a,b) -> a-b).get();

        System.out.println("max :" + max);
        System.out.println(" :" + min);
    }
}
