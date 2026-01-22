/*Program to create a banking system with three classes - BankAccount, SavingsAccount, and CurrentAccount.
The bank should have a list of accounts and methods for adding them.
Accounts should be an interface with methods to deposit, withdraw, calculate interest, and view balances.
SavingsAccount and CurrentAccount should implement the Account interface and have their own unique methods.*/

interface Accounts {

	public void deposit(double money);
	public void withdraw(double money);
	public void calculateinterest(int timeinyears);
	public void viewbalances();
	
}

class BankAccount implements Accounts{
	double interestPerYear = 1.5;
	double balance;
	BankAccount(double balance){
		this.balance = balance;
	}
	
	public void deposit(double money){
		balance += money;
		System.out.println("money is added in account new balance is " + balance);
	}
	
	public void withdraw(double money){
		balance -= money;
		System.out.println("money is withdraw from account new balance is " + balance);
	}
	
	public void calculateinterest(int timeinyears){
		System.out.println("your simple interest for " + timeinyears  +" is "+(balance*interestPerYear*timeinyears)/100 );
	}
	
	public void viewbalances(){
		System.out.println("your blance is" + balance);
	}
	
}

class SavingsAccount implements Accounts{
	double interestPerYear = 5;
	double balance;
	SavingsAccount(double balance){
		this.balance = balance;
	}
	
	public void deposit(double money){
		balance += money;
		System.out.println("money is added in account new balance is " + balance);
	}
	
	public void withdraw(double money){
		balance -= money;
		System.out.println("money is withdraw from account new balance is " + balance);
	}
	
	public void calculateinterest(int timeinyears){
		System.out.println("your simple interest for " + timeinyears  +" is "+(balance*interestPerYear*timeinyears)/100 );
	}
	
	public void viewbalances(){
		System.out.println("your blance is" + balance);
	}
	
}

class CurrentAccount implements Accounts{
	double interestPerYear = 2;
	double balance;
	CurrentAccount(double balance){
		this.balance = balance;
	}
	
	public void deposit(double money){
		balance += money;
		System.out.println("money is added in account new balance is " + balance);
	}
	
	public void withdraw(double money){
		balance -= money;
		System.out.println("money is withdraw from account new balance is " + balance);
	}
	
	public void calculateinterest(int timeinyears){
		System.out.println("your simple interest for " + timeinyears  +" is "+(balance*interestPerYear*timeinyears)/100 );
	}
	
	public void viewbalances(){
		System.out.println("your balance is " + balance);
	}
	
}

class pt3{

	public static void main(String args[]){
		SavingsAccount savingAcc = new SavingsAccount(500);
		savingAcc.deposit(500);
		savingAcc.withdraw(250);
		savingAcc.calculateinterest(5);
		savingAcc.viewbalances();
	}
}
