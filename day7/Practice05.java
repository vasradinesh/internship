//Program to sort a given array list.


import java.util.*;

class Practice05{
	public static void main(String []args){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(4);
		list.add(2);
		list.add(6);
		list.add(7);
		
		System.out.println("before sort ");
		for(int j : list){
			System.out.printf(j+ ",");
		}
		
		Collections.sort(list);
		System.out.println();
		System.out.println("After sort");
		for(int j : list){
			System.out.printf(j+ ",");
		}
		
	
	}
}