// creating my custome exception class to show my own exception message
import java.util.*;
import java.io.*;
class FileisEmpty extends Exception{
	FileisEmpty(String message){
		super(message);
	}
}


class pt2{
	public static void main(String args[]){
		try{
			Scanner input = new Scanner(System.in);
			System.out.println("enter file path you want to read");
			String fileName = input.nextLine();
			fileEmpty(fileName);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(FileisEmpty e){
			e.printStackTrace();
		}
		
	}
	
	public static void fileEmpty(String fileName)throws FileNotFoundException , FileisEmpty{
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		int lines = 0;
		if(!sc.hasNextLine()){
			throw new FileisEmpty("file is empty");
		}else{
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
				lines++;
			}
			System.out.println();
			System.out.println("file has a "+lines + " lines");
		}
		sc.close();
	}
}