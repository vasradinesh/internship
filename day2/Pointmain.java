class Point{
	double x,y;
	int xi,yi;
	
	Point(double x,double y){
		this.x = x;
		this.y = y;
	}
	
	Point(int xi,int yi){
		this.xi = xi;
		this.yi = yi;
	}
}


class Pointmain{

	public static void main(String arge[]){
	
		Point point = new Point(23.222d,20.22d);
		System.out.println(point.x + "  " + point.y);
		
		Point point2 = new Point(23,20);
		System.out.println(point2.xi + "  " + point2.yi);
	
	}


}