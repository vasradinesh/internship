//Program to create an abstract class Animal with abstract methods eat() and sleep().
//Create subclasses Lion, Tiger, and Deer that extend the Animal class and implement the eat() and sleep() methods differently based on their specific behavior.

abstract class Animal {

	abstract public void eat();
	abstract public void sleep();

}

class Lion extends Animal{
	public void eat(){
		System.out.println("Lion is eating");
	}
	public void sleep(){
		System.out.println("Lion is sleeping");
	}
}

class Tiger extends Animal{
	public void eat(){
		System.out.println("Tiger is eating");
	}
	public void sleep(){
		System.out.println("Tiger is sleeping");
	}
}

class Deer extends Animal{
	public void eat(){
		System.out.println("Deer is eating");
	}
	public void sleep(){
		System.out.println("Deer is sleeping");
	}
}


class pt15{
	public static void main(String args[]){
		Lion lion = new Lion();
		lion.eat();
		lion.sleep();
		
		Tiger tiger = new Tiger();
		tiger.eat();
		tiger.sleep();
		
		Deer deer = new Deer();
		deer.eat();
		deer.sleep();
	}
}