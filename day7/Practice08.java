//Program to compare two array lists.


import java.util.*;

class Practice08{
	public static void main(String []args){
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(6);
		list1.add(4);
		list1.add(2);
		list1.add(6);
		list1.add(7);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(6);
		list2.add(4);
		list2.add(2);
		list2.add(6);
		list2.add(7);

		System.out.println(list1.equals(list2));
		
	
	}
}
