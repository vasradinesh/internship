//Program to create an abstract class Animal with an abstract method called sound().
//Create subclasses Lion and Tiger that extend the Animal class and implement the sound() method to make a specific sound for each animal.

abstract class Animal {
	abstract public void sound();
}class Lion extends Animal{
	public void sound(){
		System.out.println("lion is roaring");
	}
}class Tiger extends Animal{
	public void sound(){
		System.out.println("tiger is roaring");
	}
}
class pt11{
	public static void main(String args[]){
		Lion lion = new Lion();
		lion.sound();
		
		Tiger tiger = new Tiger();
		tiger.sound();
	}
}
