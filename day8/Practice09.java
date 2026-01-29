//Program to create a reverse order view of the elements contained in a given tree set.



import java.util.*;
class Practice09{
	public static void main(String args[]){
		TreeSet<String> set = new TreeSet<String>();
		set.add("kartik");
		set.add("vasra");
		set.add("yoyo");
		set.add("car");
		set.add("car2");
		
		Iterator<String> it =set.descendingIterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
	}


}