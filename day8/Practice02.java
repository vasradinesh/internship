//Program to test if a hash set is empty or not.

import java.util.*;
class Practice02{
	public static void main(String args[]){
		HashSet<String> set = new HashSet<String>();
		set.add("kartik");
		set.add("vasra");
		set.add("yoyo");
		set.add("car");
		set.add("car2");
		
		if(set.size()==0){
		System.out.println("set is empty");
		}else{
		System.out.println("set is nonempty");
		}
	}


}