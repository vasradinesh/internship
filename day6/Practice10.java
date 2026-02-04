//Program to count and print all duplicates in the input string.

import java.util.*;

class Practice10{
	public static void main(String args[]){
		
		String str = "Programmer are the future";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		
		for(int i = 0;i<str.length();i++){
			char ch = str.charAt(i);
			map.put(ch,map.getOrDefault(ch,0) + 1);
		}
		
		for(Character c : map.keySet()){
			if(map.get(c) > 1){
				System.out.println("char : " + c +" count : " + map.get(c));
			}
		}

		
	}

}