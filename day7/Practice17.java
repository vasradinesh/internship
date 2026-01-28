//Program to iterate a linked list in reverse order.

import java.util.*;

class Practice17 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
		

     	System.out.println("before reverse : "+list);
		Collections.reverse(list);
     	System.out.println("before reverse : "+list);

    }
}
