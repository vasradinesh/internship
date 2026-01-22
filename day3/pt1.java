//Program to create a Animal interface with a method called bark() that takes no arguments and returns void. 
//Create a Dog class that implements Animal and overrides speak() to print "Dog is barking"

interface Animal {
	public void speak();
}
class Dog implements Animal{
	public void speak(){
		System.out.println("Dog is barking");
	}
}
class pt1{

	public static void main(String args[]){
		Dog dog = new Dog();
		dog.speak();
	}
}

