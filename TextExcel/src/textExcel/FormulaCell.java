package textExcel;

public class FormulaCell extends RealCell{
	private Spreadsheet sheet;
	private String formula;
	
	public FormulaCell(String cellText, Spreadsheet mySheet){
		super(cellText);
		formula=cellText;
		sheet=mySheet;
	}
	public double getDoubleValue(){
		String[] splittedFormula=formula.split(" ");
		double currAnswer=0.0;		//to be returned as final answer
		//This is for the first part of input of formula cell to see if it is SUM, AVG, a number, or a cell
		if(splittedFormula[1].toUpperCase().equals("SUM")){
			return sum(splittedFormula[2]);
		}else if(splittedFormula[1].toUpperCase().equals("AVG")){
			return avg(splittedFormula[2]);
		}if(splittedFormula[1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[1].toUpperCase().charAt(0)<(int)'L'+1 && !(splittedFormula[1].toUpperCase().equals("AVG"))){
			SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[1]);
			currAnswer=currAnswer + ((RealCell)sheet.getCell(cell)).getDoubleValue();
		}else if(!(splittedFormula[1].toUpperCase().equals("AVG"))&&!(splittedFormula[1].toUpperCase().equals("SUM"))){
			currAnswer=Double.parseDouble(splittedFormula[1]);	//initialize currAnswer as first number and cycle through for loop
		}
		for(int i=2;i<splittedFormula.length-1;i+=2){				//for loop to cycle through every other operator
				if(splittedFormula[i].equals("+")){			//addition
					if(splittedFormula[i+1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[i+1].toUpperCase().charAt(0)<(int)'L'+1){
						SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[i+1]);
						currAnswer+= ((RealCell)sheet.getCell(cell)).getDoubleValue();
					}else{
						double firstNum=Double.parseDouble(splittedFormula[i+1]);
						currAnswer+=firstNum;
					}
				}else if(splittedFormula[i].equals("-")){	//subtraction
					if(splittedFormula[i+1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[i+1].toUpperCase().charAt(0)<(int)'L'+1){
						SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[i+1]);
						currAnswer-= ((RealCell)sheet.getCell(cell)).getDoubleValue();
					}else{
						double firstNum=Double.parseDouble(splittedFormula[i+1]);
						currAnswer-=firstNum;
					}
				}else if(splittedFormula[i].equals("*")){	//multiplication
					if(splittedFormula[i+1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[i+1].toUpperCase().charAt(0)<(int)'L'+1){
						SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[i+1]);
						currAnswer*= ((RealCell)sheet.getCell(cell)).getDoubleValue();
					}else{
						double firstNum=Double.parseDouble(splittedFormula[i+1]);
						currAnswer*=firstNum;
					}
				}else if(splittedFormula[i].equals("/")){	//division
					if(splittedFormula[i+1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[i+1].toUpperCase().charAt(0)<(int)'L'+1){
						SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[i+1]);
						currAnswer/= ((RealCell)sheet.getCell(cell)).getDoubleValue();
				}else{
					double firstNum=Double.parseDouble(splittedFormula[i+1]);
					currAnswer/=firstNum;
				}
			}
		}
		return currAnswer;
	}
	@Override
	public String abbreviatedCellText() {
		return (getDoubleValue()+"            ").substring(0, 10);		//add however many spaces and then substring
	}
	@Override
	public String fullCellText() {
		return formula;						//return the formula itself only with correct calculations
	}
	public double sum(String range) {		//method for sum
		String[] minigrid=range.split("-");
		SpreadsheetLocation start =new SpreadsheetLocation(minigrid[0]);
		SpreadsheetLocation end =new SpreadsheetLocation(minigrid[1]);
		double sum=0;
		for(char i=minigrid[0].toUpperCase().charAt(0);i<=minigrid[1].toUpperCase().charAt(0);i++){	//incrementing char
			for(int j=start.getRow() + 1;j<=end.getRow() + 1;j++){
				//String currCell=(char)'A'+j+""+i;
				String currCell=i+""+j;		
				SpreadsheetLocation spreadsheetCell= new SpreadsheetLocation(currCell);
				sum+=((RealCell)(sheet.getCell(spreadsheetCell))).getDoubleValue();				//recursion 
			}
		}
		return sum;
	}
	public double avg(String range) {		//method for avg
		String[] minigrid=range.split("-");		//same thing as sum except adding a counter and dividing it to get the avg value
		SpreadsheetLocation start =new SpreadsheetLocation(minigrid[0]);
		SpreadsheetLocation end =new SpreadsheetLocation(minigrid[1]);
		double sum=0;
		int count=0;
		for(char i=minigrid[0].toUpperCase().charAt(0);i<=minigrid[1].toUpperCase().charAt(0);i++){
			for(int j=start.getRow() + 1;j<=end.getRow() + 1;j++){
				//String currCell=(char)'A'+j+""+i;
				String currCell=i+""+j;
				SpreadsheetLocation spreadsheetCell= new SpreadsheetLocation(currCell);
				sum+=((RealCell)(sheet.getCell(spreadsheetCell))).getDoubleValue();
				count++;
			}
		}
		return sum/count;
	}	
}