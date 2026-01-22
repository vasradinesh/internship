//Program to create an interface Playable with a method play() that takes no arguments and returns void. Create three classes Football, Volleyball, and Basketball that
//implement the Playable interface and override the play() method to play the respective sports.

interface Playable {
	public void play();
}
class Football implements Playable{
	public void play(){
		System.out.println("Football");
	}
}
class Volleyball implements Playable{
	public void play(){
		System.out.println("Volleyball");
	}
}
class Basketball implements Playable{
	public void play(){
		System.out.println("Basketball");
	}
}
class pt5{
	public static void main(String args[]){
		Basketball basketball = new Basketball();
		basketball.play();
		
		Volleyball volleyball = new Volleyball();
		volleyball.play();
	}
}