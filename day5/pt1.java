
import java.io.*;
class pt1{
	public static void main(String args[]) throws Exception{
		try(BufferedReader br = new BufferedReader(new FileReader("new.txt"))){
			String line;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		}
	}

}