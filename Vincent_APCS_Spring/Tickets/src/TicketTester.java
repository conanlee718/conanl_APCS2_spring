
public class TicketTester {
	public static void main(String args[]){
		Ticket a=new WalkupTicket(1);
		Ticket b=new AdvanceTicket(2,8);
		Ticket c=new AdvanceTicket(3,11);
		Ticket d=new StudentAdvanceTicket(4,8);
		Ticket e=new StudentAdvanceTicket(5,11);
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
	}
}
