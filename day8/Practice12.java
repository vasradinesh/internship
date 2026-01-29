//Program to get the element in a tree set which is greater than or equal to the given element.


import java.util.*;
class Practice12{
	public static void main(String args[]){
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(2);
		set.add(5);
		set.add(8);
		set.add(6);
		set.add(1);
		
		for(int a : set){
			if(a>=4){
			System.out.println(a);
			}
		}
		
	}


}
