//Program to remove a given element from a tree set.


import java.util.*;
class Practice14{
	public static void main(String args[]){
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(2);
		set.add(5);
		set.add(8);
		set.add(6);
		set.add(1);
		System.out.println("before removing perticuler element");
		System.out.println(set);
		
		set.remove(8);
		System.out.println("After removing perticuler element");
		System.out.println(set);
	}


}