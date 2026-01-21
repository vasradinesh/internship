
import java.util.*;
class Four{
 public static void main(String args[]){
 
 System.out.println(" enter index you want sum");
 Scanner sc = new Scanner(System.in);
 int n = sc.nextInt();
 
 int nm1 = 0;
 int nm2 = 1;
 int index = 0;
 int count = 0;
 int sum = 0;
 
 while(count<n){
 
 if(index%2==0){
 
 sum +=nm1;
 count++;
 }
 int next  = nm1+nm2;
 nm1 = nm2;
 nm2 = next;
 index++;
 
 }
 
 
 System.out.println("sum of first" + n + " is " + sum);
 
 }
}