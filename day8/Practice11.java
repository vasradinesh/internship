//Program to compare two tree sets.


import java.util.*;
class Practice11{
	public static void main(String args[]){
		TreeSet<String> set = new TreeSet<String>();
		set.add("black");
		set.add("white");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		
		TreeSet<String> set2 = new TreeSet<String>();
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