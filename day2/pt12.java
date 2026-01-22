//Program to create an abstract class BankAccount with abstract methods deposit() and withdraw().
//Create subclasses: SavingsAccount and CurrentAccount that extend the BankAccount class and implement the respective methods to handle deposits and withdrawals for each account type


abstract class BankAccount {
	abstract public void deposit();
	abstract public void withdraw();

}class SavingsAccount extends BankAccount{
	public void deposit(){
		System.out.println("money is credited in savingacc");
	}
	public void withdraw(){
		System.out.println("money is debited from savingacc");
	}
}class CurrentAccount extends BankAccount{
	public void deposit(){
		System.out.println("money is credited is currentacc");
	}
	public void withdraw(){
		System.out.println("money is debited from currentacc");
	}
}
class pt12{
	public static void main(String args[]){
		SavingsAccount savingacc = new SavingsAccount();
		savingacc.deposit();
		savingacc.withdraw();
		
		CurrentAccount currentacc = new CurrentAccount();
		currentacc.deposit();
		currentacc.withdraw();
	}
}