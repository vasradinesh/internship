//Program to insert an element into the array list at the first position.

import java.util.*;

class Practice02{
	public static void main(String []args){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0,4);
		list.add(0,5);
		list.add(0,6);
		list.add(0,7);
		
		for(int j : list){
			System.out.println(j);
		}
	}
}	