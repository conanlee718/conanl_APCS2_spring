package textExcel;

public class TextCell implements Cell {
	private String text;
	public TextCell(String cellText){
		text=cellText;
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String[] noParenthesisText=text.split("\"");
		return((noParenthesisText[1]+"                ").substring(0,10));
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return text;
	}

}
