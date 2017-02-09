package ticket;

public class advanceTicket extends Ticket{
	public advanceTicket(int ticket, int daysAdvance){
		super(ticket);
		if(daysAdvance>=10){
			super.setPrice(30.0);
		
		}else{
			super.setPrice(40.0);
		}
	}
}
