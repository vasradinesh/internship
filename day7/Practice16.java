//Program to check if a particular element exists in a linked list.


import java.util.*;

class Practice16{
	public static void main(String []args){
		LinkedList<String> list = new LinkedList<>();
		list.add("one");
		list.add("two");
		list.add("four");
		list.add("five");
		
		System.out.println(list.contains("one"));
		
	}
}