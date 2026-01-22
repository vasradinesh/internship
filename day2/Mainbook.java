/*# Program to create a class called "Book" with instance variables title, author, and price. Implement a default constructor and two parameterized constructors:
    a. One constructor takes title and author as parameters.
    b. The other constructor takes title, author, and price as parameters.
    c. Print the values of the variables for each constructor.*/

class Book{

	String title;
	String auther;
	int price;

	Book(){
	}

	Book(String title,String auther){
		this.title = title;
		this.auther = auther;
	}

	Book(String title,String auther,int price){
		this.title = title;
		this.auther = auther;
		this.price = price;
	}

}

class Mainbook{

	public static void main(String args[]){

		Book firstbook = new Book("java","jams goslin");
		System.out.println("title of book is - "+firstbook.title + " auther is " + firstbook.auther);

		Book secondbook = new Book("python","ghchhc",664);
		System.out.println("title of book is - "+secondbook.title + " auther is " + secondbook.auther + " price is " + secondbook.price);
}
}