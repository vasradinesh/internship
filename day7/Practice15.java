//Program to remove the first and last elements from a linked list.


import java.util.*;

class Practice15{
	public static void main(String []args){
		LinkedList<String> list = new LinkedList<>();
		list.add("one");
		list.add("two");
		list.add("four");
		list.add("five");
		
		System.out.println(list);
		list.removeFirst();
		list.removeLast();
		System.out.println(list);
		
	}
}