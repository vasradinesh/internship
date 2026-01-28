//Program to iterate through all elements in a linked list.

import java.util.*;

class Practice11{
	public static void main(String []args){
		LinkedList<String> list = new LinkedList<>();
		list.add("one");
		list.add("two");
		list.add("four");
		list.add("five");
		
		for(String str : list){
			System.out.println(str);
		}
		
	}
}
