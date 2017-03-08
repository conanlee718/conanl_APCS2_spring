package textExcel;

public class TextCell implements Cell {
	private String text;
	String cellText;
	public TextCell(String text){
		cellText=text;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return((cellText+"                ").substring(0,10));
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return cellText;
	}

}
