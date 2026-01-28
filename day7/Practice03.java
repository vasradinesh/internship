//Program to update an array element by the given element.

import java.util.*;

class Practice03{
	public static void main(String []args){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0,4);
		list.add(0,5);
		list.add(0,6);
		list.add(0,7);
		System.out.println("before change ");
		for(int j : list){
			System.out.printf(j+ ",");
		}
		list.set(0,8);
		System.out.println();
		System.out.println("After change");
		for(int j : list){
			System.out.printf(j+ ",");
		}
	}
}	