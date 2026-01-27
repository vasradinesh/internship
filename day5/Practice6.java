
class Practice6{
    public static void main(String[] args) {
        try {

            int result = 10 / 0;  
            int[] arr = new int[3];    
            System.out.println(arr[5]);
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e);
        }

        System.out.println("continues...");
    }
}

