/*# Program to create a class called "Cat" with instance variables name and age.
 Implement a default constructor that initializes the name to "Unknown" and the age to 0. Print the values of the variables.
# Program to create a class called Dog with instance variables name and color. 
Implement a parameterized constructor that takes name and color as parameters and initializes the instance variables. Print the values of the variables*/

class Cat{
	int age;
	String name;

Cat(){
	this.age = 0;
	this.name = "unkhown";
	} 
}

class Dog{
	String color;
	String name;

	Dog(String name,String color){
		this.name = name;
		this.color = color;
	} 
}

class Main{

	public static void main(String args[]){

		Cat cat = new Cat();
		System.out.println("age of cat is - "+cat.age);
		System.out.println("name of cat is - "+cat.name);


		Dog dog = new Dog("tomu","black");
		System.out.println("name of dog is - "+ dog.name);
		System.out.println("color of dog is - " + dog.name);
}
}