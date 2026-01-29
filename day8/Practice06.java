//Program to create a tree set, add some colors (strings) and print out the tree set.

import java.util.*;

public class Practice06 {
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
