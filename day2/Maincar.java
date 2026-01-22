//Program to create a class called Vehicle with a method called drive().
//Create a subclass called Car that overrides the drive() method to print "Repairing a car".

class Drive{
	public void drive(){
		System.out.println("drive");
	}

}
class Car extends Drive{
	public void drive(){
		System.out.println("Repairing a car");
	}
}

class Maincar{
	public static void main(String args[]){
		Car car = new Car();
		car.drive();
	}
}