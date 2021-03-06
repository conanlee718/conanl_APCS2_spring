package textExcel;

public class PercentCell extends RealCell{
	String percent=getText();
	
	
	
	public double getDoubleValue(){
		
		percent=percent.substring(0,percent.length()-1);
		double decimal=Double.parseDouble(percent);
		return decimal/100;
	}
	
	public PercentCell(String cellText){
		super(cellText);
	}
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String percent=getText();
		percent=percent.substring(0,percent.indexOf("."))+"%";
		percent+="            ";
		return percent.substring(0,10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return getDoubleValue()+"";
		
	}
	
}
