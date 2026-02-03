
import java.util.*;

//Program to implement a lambda expression to convert a list of strings to uppercase and lowercase.


public class Practice03 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("dinesh","kartik","don","donkey");
        List<String> uppercase = new ArrayList<>();
        List<String> lowecase = new ArrayList<>();

        list.forEach(s -> {
            uppercase.add(s.toUpperCase());
            lowecase.add(s.toLowerCase());
        });


        list.replaceAll(l  ->  l.toUpperCase());
        System.out.println("list in uppercase by replaceall : " + list);
        list.replaceAll(l  ->  l.toLowerCase());
        System.out.println("list in lowercase by replaceall : " + list);


        System.out.println("list in uppercase : " + uppercase);
        System.out.println("list in lowercase : " + lowecase);

    }
}
