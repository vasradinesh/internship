//Program to create an interface Sortable with a method sort() that sorts an array of integers in ascending order.
//Create two classes BubbleSort and SelectionSort that implement the Sortable interface and provide their own implementations of the sort() method.

interface Sortable {
    public void sort(int[] arr);
}

class BubbleSort implements Sortable {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class SelectionSort implements Sortable {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
public class pt4{
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 8, 4, 2};
        int[] arr2 = {9, 1, 6, 7, 3};

        Sortable bubble = new BubbleSort();
        bubble.sort(arr1);
		for (int i : arr1) {
            System.out.print(i + " ");
        }
		
        Sortable selection = new SelectionSort();
        selection.sort(arr2);
        System.out.println();
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}


