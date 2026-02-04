//Program to demonstrate nested try-catch blocks.


public class practice7 {
    public static void main(String args[]) {
        try {
            int a = 10;
            int b = 0;

            try {
                int c = a / b;
                System.out.println(c);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }

            int[] arr = new int[3];
            arr[4] = 20;

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("Program ended");
    }
}