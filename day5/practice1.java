//Program that throws an exception and catch it using a try-catch block.


class Practice1{
	public static void main(String args[]){
		try{
		exception();
		}catch(ArithmeticException e){
			e.printStackTrace();
		}
		
	}
	
	public static void exception() throws ArithmeticException{
		System.out.println(10/0);
	}
}