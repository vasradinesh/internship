//Program to find the first non-repeating character in a string.

import java.util.*;

class Practice9{
	public static void main(String args[]){
		
		String str = "newnewA";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		
		for(int i = 0;i<str.length();i++){
			char ch = str.charAt(i);
			map.put(ch,map.getOrDefault(ch,0) + 1);
		}
		
		for(Character c : map.keySet()){
			if(map.get(c) == 1){
				System.out.println("the first non-repeating character is " + c);
			}
		}

		
	}

}