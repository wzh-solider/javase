public class Homework03 {
	public static void main(String[] args) {
		Book b = new Book();
		b.price = 90;
		b.updataPrice();
		System.out.println("140的图书价格变为==>" + b.price);
	}
}

class Book {
	int price;
	public void updataPrice() {
		if (this.price > 150) this.price =  150;
		else if(this.price > 100) this.price = 100;
	} 
}