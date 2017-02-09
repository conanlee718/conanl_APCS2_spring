package ticket;

public class studentAdvanceTicket extends advanceTicket{
	public studentAdvanceTicket(int ticket,int daysAdvance){
		super(ticket,daysAdvance);
		if(daysAdvance<10){
			super.getPrice();
		}else{
			super.getPrice();
		}
	}
}
