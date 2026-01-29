//Program to find numbers less than 7 in a tree set.


import java.util.*;
class Practice04{
	public static void main(String args[]){
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(2);
		set.add(5);
		set.add(8);
		set.add(6);
		set.add(1);
		
		for(int a : set){
			if(a<7){
			System.out.println(a);
			}
		}
		
	}


}

