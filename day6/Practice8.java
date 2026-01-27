//Program to print the result of removing duplicates from a given string.

class Practice8{
	public static void main(String args[]){
		
		String s1 ="hello programer ";
		StringBuilder sn = new StringBuilder("");
		
		System.out.println("before removing duplicate " + s1 ); 
		
		for(int i = 0;i<s1.length();i++){
			char c = s1.charAt(i);
			if(sn.indexOf(s1.valueOf(c))  == -1){
				sn.append(s1.charAt(i));
			}
		}
		System.out.println("After removing duplicate " + sn); 
		
	}

}