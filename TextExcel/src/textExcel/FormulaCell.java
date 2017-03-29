package textExcel;

public class FormulaCell extends RealCell{

	private String formula;
	public FormulaCell(String cellText){
		super(cellText);
		formula=cellText;
	}
	
	public double getDoubleValue(){
		String[] splittedFormula=formula.split(" ");
		double currAnswer=Double.parseDouble(splittedFormula[1]);;
		
		for(int i=2;i<splittedFormula.length-1;i+=2){
			double firstNum=Double.parseDouble(splittedFormula[i+1]);
			
			if(splittedFormula[i].equals("+")){
				currAnswer+=firstNum;
			}else if(splittedFormula[i].equals("-")){
				currAnswer-=firstNum;
			}else if(splittedFormula[i].equals("*")){
				currAnswer*=firstNum;
			}else if(splittedFormula[i].equals("/")){
				currAnswer/=firstNum;
			}
			
		}
		
		return currAnswer;				
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return (getDoubleValue()+"       ").substring(0, 10);
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return formula;
	}
	
	
}
