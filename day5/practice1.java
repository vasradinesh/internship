//Program to create a method that takes a string as input and throws customized exception if the string does not contain vowels.
import java.util.*;
class Novowels extends Exception{
	Novowels(String message){
		super(message);
	}
}


class practice1{
	public static void main(String args[]){
		try{
			novowels();
		}catch(Novowels e){
			e.printStackTrace();
		}
		
	}
	
	public static void novowels() throws Novowels{
		Scanner input = new Scanner(System.in);
		System.out.println("enter word");
		String word = input.nextLine();
		int count = 0;
		int i = 0;
		while(i<=word.length()-1){
			if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u' ){
				count++;	
			}
			i++;
		}
			
		if(count == 0){
			throw new Novowels("word does not have any vowels");
		}else{
			System.out.println(word);
		}
		input.close();
	}
}