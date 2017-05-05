package textExcel;

public class RealCell implements Cell {
	String value;
	public RealCell (String number){
		value=number;
	}
	public String abbreviatedCellText() {
		String newContent = value;
		newContent=newContent+"          ";
		return newContent.substring(0, 10);
	}
	public String fullCellText() {
		return value;
	}
	public double getDoubleValue(){
		return Double.parseDouble(value);
	}
}
