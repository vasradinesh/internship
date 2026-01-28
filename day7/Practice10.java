//Program to insert the specified element at the specified position in the linked list.

import java.util.*;

class Practice10{
	public static void main(String []args){
		LinkedList<String> list = new LinkedList<>();
		list.add("one");
		list.add("two");
		list.add("four");
		list.add("five");
		
		System.out.println(list);
		list.add(2,"threee");
		System.out.println(list);
		
	}
}