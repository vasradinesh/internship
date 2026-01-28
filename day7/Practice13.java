//Program to insert the specified element at the end of a linked list.

import java.util.*;

class Practice13{
	public static void main(String []args){
		LinkedList<String> list = new LinkedList<>();
		list.add("one");
		list.add("two");
		list.add("four");
		list.add("five");
		
		System.out.println(list);
		list.addLast("threee");
		System.out.println(list);
		
	}
}