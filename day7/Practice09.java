//Program to print all the elements of an ArrayList using the elements' position.
import java.util.*;
class Practice09{
	public static void main(String []args){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		
		for(int j : list){
			System.out.println(j);
		}
	}
}