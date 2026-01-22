//Program to create an interface Shape with the getArea() method.
//Create three classes Rectangle, Circle, and Triangle that implement the Shape interface. Implement the getArea() method for each of the three classes.



interface Shape {
	public void getArea();
}
class Rectangle implements Shape{

	double height;
	double width;
	
	Rectangle(double height ,double width){
		this.height = height;
		this.width =width;
	}
	public void getArea(){
		System.out.println("area of Rectangle is - " + (height*width));
	}
}

class Circle implements Shape{
	double r;
	Circle(double r){
		this.r = r;
	}
	public void getArea(){
		System.out.println("area of circle is - " + 3.14*(r*r));
	}
}

class Triangle implements Shape{
	double base,height;
	Triangle(double base , double height){
		this.base = base;
		this.height = height;
	}
	public void getArea(){
		System.out.println("area of Triangle is - " + (0.5*base*height));
	}
}
class pt2{

	public static void main(String args[]){
		Rectangle rectangle = new Rectangle(4,6);
		rectangle.getArea();
		
		Circle circle  = new Circle(5);
		circle.getArea();
		
		Triangle triangle = new Triangle(3,5);
		triangle.getArea();
		
	}
}