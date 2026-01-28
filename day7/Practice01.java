import java.util.*;

class Practice01{
	public static void main(String []args){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		for(int j : list){
			System.out.println(j);
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}