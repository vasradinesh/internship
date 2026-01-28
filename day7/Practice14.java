//Program to display elements and their positions in a linked list.


import java.util.*;

class Practice14{
	public static void main(String []args){
		LinkedList<String> list = new LinkedList<>();
		list.add("one");
		list.add("two");
		list.add("four");
		list.add("five");
		int i=0;
		for(String str : list){
			System.out.println("postion : " +i +" data : "+str);
			i++;
		}
		
	}
}
