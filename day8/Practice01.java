//Program to iterate through all elements in a hash set.
import java.util.*;
class Practice01{
	public static void main(String args[]){
		HashSet<String> set = new HashSet<String>();
		set.add("kartik");
		set.add("vasra");
		set.add("yoyo");
		set.add("car");
		set.add("car2");
		
		Iterator<String> it =set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
	}


}