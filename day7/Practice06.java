//Program to copy one arraylist into another.


import java.util.*;

class Practice06{
	public static void main(String []args){
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(6);
		list1.add(4);
		list1.add(2);
		list1.add(6);
		list1.add(7);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(10);
		list2.add(40);
		list2.add(20);
		list2.add(60);
		list2.add(70);

		
		System.out.println("before copy ");
		for(int j : list1){
			System.out.printf(j+ ",");
		}
		
		Collections.copy(list1,list2);
		
		System.out.println();
		
		System.out.println("After copy");
		for(int j : list1){
			System.out.printf(j+ ",");
		}
		for(int j : list2){
			System.out.printf(j+ ",");
		}
		
		
	
	}
}
