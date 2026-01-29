//Program to compare two hash set.

import java.util.*;
class Practice05{
	public static void main(String args[]){
		HashSet<String> set = new HashSet<String>();
		set.add("kartik");
		set.add("vasra");
		set.add("yoyo");
		set.add("car");
		set.add("car2");
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("kartik");
		set2.add("vasra");
		set2.add("yoyo");
		set2.add("car");
		set2.add("car2");
		
		if(set.equals(set2)){
		System.out.println("both set is same");
		}else{
		System.out.println("both set is not same");
		}
	}


}