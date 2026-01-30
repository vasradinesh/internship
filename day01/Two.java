import java.util.*;
class Two{
 public static void main(String args[]){
 
 System.out.println(" enter number you want to check number is armstrong");
 Scanner sc = new Scanner(System.in);
 int n = sc.nextInt();
 int sum = 0;
 if(n<0){
	 System.out.println("given number is armstrong number");
 
 }
 while(n>0){
 
 int digit = n%10;
 sum = (digit*digit*digit) + sum;
 n = n/10;
 }
 
 if(n==sum){
 System.out.println("given number is armstrong number");
 }else{
	  System.out.println("given number is not armstrong number");

 }
 
 }
}