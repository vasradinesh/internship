//Program to create a class called Employee with methods called work() and getSalary().
// Create a subclass called HRManager that overrides the work() method and adds a new method called addEmployee()


class Employee {
	int salary;
	public Employee(int salary){
		this.salary = salary;
	}
	public void work(){
		System.out.println("employee");
	}
	public int getSalary(){
		return salary;
	}
}
class HRManager extends Employee{
	public HRManager(int salary) {
        super(salary);
    }
	public void work(){
		System.out.println("HRManager");
	}
	public void addEmployee(){
		System.out.println("new employee is added");
	}
}

class Pt8{
	public static void main(String args[]){
		HRManager hrmanger = new HRManager(4000);
		hrmanger.addEmployee();
		hrmanger.work();
	}

}