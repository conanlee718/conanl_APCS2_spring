package textExcel;

public class FormulaCell extends RealCell{

	
	
	public double getDoubleValue(){
		return 0.0;				//for part A just return anything
	}
	public FormulaCell(String cellText){
		super(cellText);
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return super.abbreviatedCellText();
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return super.fullCellText();
	}
	
	
}
