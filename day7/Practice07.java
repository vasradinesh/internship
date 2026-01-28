//Program to extract a portion of an array list.

import java.util.*;

class Practice07{
	public static void main(String []args){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(4);
		list.add(2);
		list.add(6);
		list.add(7);
		
		System.out.println(list.subList(0,3));
	
	}
}