
import java.lang.reflect.Array;
import java.util.*;

//Write a Java program to count the number of strings in a list that start with a specific letter using streams.

public class Practice07 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("car" ,"bike","bmw","activa");
        long count = list.stream().filter(s->s.startsWith("b")).count();

        System.out.println(count);
    }
}
