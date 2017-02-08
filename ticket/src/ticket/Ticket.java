package ticket;

abstract class Ticket {
	int ticket;
	double price;

	public Ticket(int number){
		
	}
	public double getPrice(double price){
		price=50.0;
		return(price);
	}
	public String toString(){
		return("Number: "+number+", Price: "+getPrice());
	}
}
	
