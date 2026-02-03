//Program to implement a lambda expression to concatenate two strings.

import java.util.function.BiFunction;


interface Concat {
    String concat(String s1, String s2);
} 



public class Practice08 {
    public static void main(String[] args) {

        Concat c1 = (a,b)->a+b;
        System.out.println(c1.concat("s1", "s2"));

        BiFunction<String,String,String> f =  (a,b) -> a.concat(b);
        System.out.println(f.apply("yo", "yo"));

    }
}
