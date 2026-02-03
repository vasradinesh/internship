//Program to implement a lambda expression to count words in a sentence.

import java.util.function.Function;

public class Practice09 {
    public static void main(String[] args) {

        Function<String,Integer> f = sentence -> sentence.trim().split("\\s+").length;

        System.out.println(f.apply("ehllo whay arnad  idnad"));
    }
}
