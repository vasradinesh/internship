//Program to add all the elements of a specified tree set to another tree set.


import java.util.*;
class Practice08{
	public static void main(String args[]){
		TreeSet<String> set = new TreeSet<String>();
		set.add("kartik");
		set.add("vasra");
		set.add("yoyo");
		set.add("car");
		set.add("car2");
		
		TreeSet<String> set2 = new TreeSet<String>(set);
		
		Iterator<String> it =set2.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
	}


}