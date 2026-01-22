
/* # Program to create a class called Account with instance variables accountNumber and balance. Implement a parameterized constructor that initializes these variables with validation:
    a. accountNumber should be non-null and non-empty.
    b. balance should be non-negative.
    c. Print an error message if the validation fails
	*/
class Account{

	String accountnumber;
	double blance;

	Account(String accountnumber,double blance){
		if(accountnumber==null || accountnumber.trim().isEmpty()){
			System.out.println("Enter correct accountnumber number");
		}else if(blance<0){
			System.out.println("Enter correct (non nagative) blance");
		}else{
			this.accountnumber = accountnumber;
			this.blance = blance;
		}
	}
}

class Mainaccount{
	public static void main(String args[]){
		Account account = new Account("",10);
		System.out.println("your accountnumber "+account.accountnumber+" and blance is " +  account.blance);
}
}