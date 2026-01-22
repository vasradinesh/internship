//Program to create a class known as Person with methods called getFirstName() and getLastName().
//Create a subclass called Employee that adds a new method named getEmployeeId() and overrides the getLastName() method to include the employee's job titleclass 

class Person{
	String firstname;
	String LastName;
	public Person(String firstname,String LastName){
		this.firstname = firstname;
		this.LastName = LastName;
	}
	public void getFirstName(){
		System.out.println("firstname is "+firstname);
	}
	public void getLastName(){
		System.out.println("LastName is " + LastName);
	}
}
class Employee  extends Person{
	String EmployeeId;
	String jobtitle;
	public Employee(String firstname,String LastName,String EmployeeId,String jobtitle){
		super(firstname,LastName);
		this.EmployeeId = EmployeeId;
		this.jobtitle = jobtitle;
	
	}
	public void getEmployeeId(){
		System.out.println("EmployeeId is " + EmployeeId);
	}
	public void getLastName(){
		System.out.println("LastName is " + LastName + "jobtitle is " + jobtitle);
	}
}

class Pt9{
	public static void main(String args[]){
		Employee employee = new Employee("ajay","talvar","32123","java dev");
		employee.getFirstName();
		employee.getLastName();
		employee.getEmployeeId();
		
	}

}