//Program to convert a linked list to an array list.

import java.util.*;

class Practice19 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
		
		ArrayList<String> arraylist = new ArrayList<>(list);
     	System.out.println("linkedlist : "+list);
     	System.out.println("arraylist : "+arraylist);

    }
}
