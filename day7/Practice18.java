//Program to copy a linked list to another linked list.

import java.util.*;

class Practice18 {
    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
		LinkedList<String> list2 = new LinkedList<>();
		list2.add("one");
		list2.add("two");
		list2.add("four");
		list2.add("five");
		
		
		

     	System.out.println("before copy : "+list1);
     	System.out.println("before copy : "+list2);
		Collections.copy(list1,list2);
		System.out.println("after copy list2 into list1: "+list1);
     	System.out.println("after copy list2 into list1: "+list2);

    }
}
