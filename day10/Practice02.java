
import java.util.function.Predicate;

//Program to implement a lambda expression to check if a given string is empty.

public class Practice02 {
    public static void main(String[] args) {
        Predicate<String> st = s-> s.isEmpty();
        System.out.println(st.test(""));
    }
}
