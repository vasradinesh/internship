//Program to create a vehicle class hierarchy. The base class should be Vehicle, with subclasses Truck, Car and Motorcycle. 
//Each subclass should have properties such as make, model, year, and fuel type.
// Implement methods for calculating fuel efficiency, distance traveled, and maximum speed.

class Vehicle{
	String make;
	String model;
	int year;
	String fueltype;
	
	public Vehicle(String make,String model,int year,String fueltype){
		this.make =make;
		this.fueltype = fueltype;
		this.year = year;
		this.model = model;
	}

}
class Truck extends Vehicle{
	
	public Truck(String make,String model,int year,String fueltype){
		super(make,model,year,fueltype);
	}
	public void fuelefficiencytruck(){
		System.out.println("and fuel efficiency of truck is 300leter");
	}
	public void distancetraveled(){
		System.out.println("and distance traveled by truck is 5000km");
	}
	public void maxspeed(){
		System.out.println("and maximum speed of truck is 100km/h");
	}
}
class Car extends Vehicle{
	public Car(String make,String model,int year,String fueltype){
		super(make,model,year,fueltype);
	}
	public void fuelefficiencycar(){
		System.out.println("and fuel efficiency of car is 50leter");
	}
	public void distancetraveled(){
		System.out.println("and distance traveled by car is 50000km");
	}
	public void maxspeed(){
		System.out.println("and maximum speed of car is 80km/h");
	}
}
class Motorcycle extends Vehicle{
	public Motorcycle(String make,String model,int year,String fueltype){
		super(make,model,year,fueltype);
	}
	public void fuelefficiencymotorcycle(){
		System.out.println("and fuel efficiency of motorcycle is 10leter ");
	}
	public void distancetraveled(){
		System.out.println("and distance traveled by motorcycle is 5000km ");
	}
	public void maxspeed(){
		System.out.println("and maximum speed of motorcycle is 80km/h ");
	}
}

class Pt10{
	public static void main(String args[]){
		Motorcycle motorcycle = new Motorcycle("Honda","hero honda",2005,"petrol");
		System.out.println(motorcycle.make + " make " + motorcycle.model + " in " + motorcycle.year + " fueltype is " + motorcycle.fueltype);
		motorcycle.fuelefficiencymotorcycle();
		motorcycle.distancetraveled();
		motorcycle.maxspeed();
		System.out.println("||");
		
		Car car = new Car("tata","scorpio",2014,"disle");
		System.out.println(car.make + " make " + car.model + " in " + car.year + " fueltype is " + car.fueltype);
		car.fuelefficiencycar();
		car.distancetraveled();
		car.maxspeed();
		System.out.println("||");

		Truck truck = new Truck("volvo","Volvo truck",2000,"disle");
		System.out.println(truck.make + " make " + truck.model + " in " + truck.year + " fueltype is " + truck.fueltype);
		truck.fuelefficiencytruck();
		truck.distancetraveled();
		truck.maxspeed();
		System.out.println("||");
	}


}