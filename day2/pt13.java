//Program to create an abstract class Employee with abstract methods calculateSalary() and displayInfo().
//Create subclasses Manager and Programmer that extend the Employee class and implement the respective methods to calculate salary and display information for each role.

abstract class Employee {
	int id;
	String name;
	
	public Employee(int id , String name){
		this.id = id;
		this.name = name;
	}
	
	abstract public void calculateSalary();
	abstract public void displayInfo();

}class Manager extends Employee{

	double salary;
	
	public Manager(int id , String name,double salary){
		super(id,name);
		this.salary = salary;
	}
	public void displayInfo(){
		System.out.println("name - " + name);
		System.out.println("id - " + id);
	}
	public void calculateSalary(){
		System.out.println("Manager salary is - " + salary);
	}
	
	
	
}class Programmer extends Employee{
	double salary;
	
	public Programmer(int id , String name,double salary){
		super(id,name);
		this.salary = salary;
	}
	public void displayInfo(){
		System.out.println("name - " + name);
		System.out.println("id - " + id);
	}
	public void calculateSalary(){
		System.out.println("Programmer salary is - " + salary);
	}
}
class pt13{
	public static void main(String args[]){
		Programmer programmer = new Programmer(122,"adi",32000);
		programmer.displayInfo();
		programmer.calculateSalary();
		
		Manager manager = new Manager(111,"virat" , 130000);
		manager.displayInfo();
		manager.calculateSalary();
	}
}