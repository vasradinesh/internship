//Program to convert a hash set to an array.

import java.util.*;
class Practice03{
	public static void main(String args[]){
		HashSet<String> set = new HashSet<String>();
		set.add("kartik");
		set.add("vasra");
		set.add("yoyo");
		set.add("car");
		set.add("car2");
		
		String []str = new String[set.size()];
		set.toArray(str);
		
		for(String s : str){
			System.out.println(s);
		}
		
	}


}

