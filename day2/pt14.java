//Program to create an abstract class Vehicle with abstract methods startEngine() and stopEngine().
//Create subclasses Car and Motorcycle that extend the Vehicle class and implement the respective methods to start and stop the engines for each vehicle type.

abstract class Vehicle {
	
	abstract public void startEngine();
	abstract public void stopEngine();

}class Car extends Vehicle{
	public void startEngine(){
		System.out.println("car engine start");
	}
	public void stopEngine(){
		System.out.println("car engine stop");
	}
	
}class Motorcycle extends Vehicle{
	public void startEngine(){
		System.out.println("motorcycle engine start");
	}
	public void stopEngine(){
		System.out.println("motorcycle engine Stop");
	}
}

class pt14{
	public static void main(String args[]){
		Car car = new Car();
		car.startEngine();
		car.stopEngine();
		
		Motorcycle motorcycle = new Motorcycle();
		motorcycle.startEngine();
		motorcycle.stopEngine();
	}
}
