//Program to iterate through all elements in a tree set.

import java.util.*;

public class Practice07 {
    public static void main(String args[]){
        TreeSet<String> set = new TreeSet<String>();
		set.add("black");
		set.add("white");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		
		Iterator<String> it =set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
			
		}
    }
    
}