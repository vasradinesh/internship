//Program lambda expression to implement a lambda expression to calculate the factorial of a given number.

interface Factorial {
    int factorial(int n);
} 


public class Practice07 {
    public static void main(String[] args) {
        Factorial factorial = n ->{
            int f =1;
            int i =1;
            while (i<=n) {
                f = f*i;
                i++;
            }
            return f;
        };
        System.out.println(factorial.factorial(5));
    }
}
