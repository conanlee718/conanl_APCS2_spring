
public abstract class Ticket {
	private int number;
	public Ticket(int number){
		this.number = number;
	}
	public abstract double getPrice();
	public int getNumber(){
		return number;
	}
	public String toString(){
		return "Number: " + number + ", Price: " + getPrice();
	}
}
