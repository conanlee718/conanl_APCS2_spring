package ticket;

public abstract class Ticket {
	private int ticket;
	private double price=50.0;

	public Ticket(int ticket){
		this.ticket=ticket;
	}
	public double getPrice(){
		return(price);
	}
	public void setPrice(double p){
		this.price=p;
	}
	public String toString(){
		return("Number: "+this.ticket+", Price: "+getPrice());
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
