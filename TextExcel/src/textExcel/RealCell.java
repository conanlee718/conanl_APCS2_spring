package textExcel;

public class RealCell implements Cell {

	private String text;
	
	public RealCell(String cellText){
		text=cellText;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String paddedToTen=text;
		return (paddedToTen+"           ").substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return text;
	}
	
	public double getDoubleValue(){
		return 0.0;
	}
	public String getText(){
		return text;
	}
	
}
