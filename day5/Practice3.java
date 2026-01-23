//Program that reads a list of integers from the user and throws an exception if any numbers are duplicates.


import java.util.*;

class DuplicateNumberException extends Exception {
    DuplicateNumberException(String message) {
        super(message);
    }
}

class Practice3 {
    public static void main(String[] args) {
        try {
            checkDuplicates();
        } catch (DuplicateNumberException e) {
            e.printStackTrace();
        }
    }

    public static void checkDuplicates() throws DuplicateNumberException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();

        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();

            if (!set.add(arr[i])) {
                throw new DuplicateNumberException(
                    "Duplicate number found: " + arr[i]
                );
            }
        }

        System.out.println("No duplicates found.");
        input.close();
    }
}


