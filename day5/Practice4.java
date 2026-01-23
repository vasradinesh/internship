//Program to demonstrate a checked exception using FileNotFoundException.
import java.io.*;
class Practice4 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("newq12.txt"));
            String line = br.readLine();
            System.out.println(line);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
