//Program to retrieve and remove the first element of a tree set.

import java.util.*;
class Practice13{
	public static void main(String args[]){
		TreeSet<String> set = new TreeSet<String>();
		set.add("kartik");
		set.add("vasra");
		set.add("yoyo");
		set.add("car");
		set.add("car2");
		System.out.println("before removing ");
		System.out.println(set);

		set.pollFirst();
		
		System.out.println("After removing ");
		System.out.println(set);

	}


}