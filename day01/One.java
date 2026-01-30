import java.util.*;
class One{

public static void main(String args[]){

System.out.println("hello");

System.out.println("enter number");

Scanner sc = new Scanner(System.in);
int no = sc.nextInt();
boolean isprime = true;

if(no<=1){
	isprime=false;
}else{
	for(int i=2;i<=no/2;i++){
		if(no%i==0){
			isprime=false;
			break;
		}
	}
}
if(isprime){
	System.out.println("given number is prime");
	}else{
			System.out.println("given number is not prime");
	}
}
}