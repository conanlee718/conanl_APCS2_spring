package textExcel;

public class TextCell implements Cell {
	private String text;
	public TextCell(String cellText){
		text=cellText;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String paddedToTen="";
		paddedToTen=text.substring(1, text.length()-1);
		paddedToTen+="                    ";
		return paddedToTen.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return text;
		
	}

}
