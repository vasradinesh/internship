// Program to create a class called Shape with a method called getArea()
// Create a subclass called Rectangle that overrides the getArea() method to calculate the area of a rectangle.

class Shape {
	public void getArea(){
		System.out.println("shape");
	} 
}
class Rectangle extends Shape{
	float h;
	float w;
	
	Rectangle(float h, float w){
		this.h = h;
		this.w = w;
	}
	
	public void getArea(){
		System.out.println(w*h);
	} 
}
class Pt7{

	public static void main(String args[]){
		Rectangle rec = new Rectangle(12f,13f);
		rec.getArea();
	}

}