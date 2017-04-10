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
		double currAnswer=0.0;
		//This is for the first part of input of formula cell to see if it is SUM, AVG, a number, or a cell
		if(splittedFormula[1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[1].toUpperCase().charAt(0)<(int)'L'+1){
			SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[1]);
			currAnswer=currAnswer + ((RealCell)sheet.getCell(cell)).getDoubleValue();
		}else if(splittedFormula[1].toUpperCase().equals("SUM")){
			String[] range=splittedFormula[2].split("-");
			SpreadsheetLocation start =new SpreadsheetLocation(range[0]);
			SpreadsheetLocation end =new SpreadsheetLocation(range[1]);
			
			currAnswer=((RealCell)sheet.getCell(start)).getDoubleValue();
			
			
				
			/*
			for(int rows=start.getRow();rows<end.getRow();rows++){
				for(int cols=start.getCol();cols<end.getCol();cols++){
					SpreadsheetLocation inbetweenCell=new SpreadsheetLocation((int)'A'+cols+""+rows);
					String contents=cells[rows][cols].abbreviatedCellText();
					String[] splittedContents =contents.split(" ");
					if(sheet.getCell(inbetweenCell)instanceof RealCell){
						for(int i=0;i<splittedContents.length;i++){
							currAnswer+=Double.parseDouble(splittedContents[i]);
						}
						
					}
			}
				
		}*/
			
		}else if(splittedFormula[1].toUpperCase().equals("AVG")){
			String[] range=splittedFormula[2].split("-");
			SpreadsheetLocation start =new SpreadsheetLocation(range[0]);
			SpreadsheetLocation end =new SpreadsheetLocation(range[1]);
			currAnswer=((RealCell)sheet.getCell(start)).getDoubleValue();
			
			
		}else{
			currAnswer=Double.parseDouble(splittedFormula[1]);;	//initialize currAnswer as first number and cycle through for loop
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
	/*
	public double getDoubleValue(){
		String[] splittedFormula=formula.split(" ");
		double currAnswer=0.0;
		//This is for the first part of input of formula cell to see if it is SUM, AVG, a number, or a cell
		for(int i=2;i<splittedFormula.length-1;i+=2){
			if(splittedFormula[i].equals("+")){			//addition
				if(splittedFormula[i-1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[i-1].charAt(0)<(int)'L'+1){
					SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[i-1]);
					currAnswer=currAnswer + ((RealCell)sheet.getCell(cell)).getDoubleValue();
				}else{
					double firstNum=Double.parseDouble(splittedFormula[i-1]);
					currAnswer+=firstNum;
				}
			}else if(splittedFormula[i].equals("-")){	//subtraction
				if(splittedFormula[i-1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[i-1].charAt(0)<(int)'L'+1){
					SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[i-1]);
					currAnswer=currAnswer - ((RealCell)sheet.getCell(cell)).getDoubleValue();
				}else{
					double firstNum=Double.parseDouble(splittedFormula[i-1]);
					currAnswer-=firstNum;
				}
			}else if(splittedFormula[i].equals("*")){	//multiplication
				if(splittedFormula[i-1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[i-1].charAt(0)<(int)'L'+1){
					SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[i-1]);
					currAnswer=currAnswer * ((RealCell)sheet.getCell(cell)).getDoubleValue();
				}else{
					double firstNum=Double.parseDouble(splittedFormula[i-1]);
					currAnswer*=firstNum;
				}
			}else if(splittedFormula[i].equals("/")){	//division
				if(splittedFormula[i-1].toUpperCase().charAt(0)>(int)'A'-1 && splittedFormula[i-1].charAt(0)<(int)'L'+1){
					SpreadsheetLocation cell = new SpreadsheetLocation(splittedFormula[i-1]);
					currAnswer=currAnswer / ((RealCell)sheet.getCell(cell)).getDoubleValue();
				}else{
					double firstNum=Double.parseDouble(splittedFormula[i-1]);
					currAnswer/=firstNum;
				}
			}else if(splittedFormula[1].toUpperCase().equals("SUM")){
			
			
			
			}else if(splittedFormula[1].toUpperCase().equals("AVG")){
			
			
			
			
			}else {
				currAnswer=Double.parseDouble(splittedFormula[i-1]);
			}
		}
		return currAnswer;
	}*/
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return (getDoubleValue()+"            ").substring(0, 10);		//add however many spaces and then substring
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return formula;						//return the formula itself only with correct calculations
	}
	/*public double getSum(){
		String[] splittedFormula=formula.split(" ");
		String[] range=splittedFormula[2].split("-");
		SpreadsheetLocation start =new SpreadsheetLocation(range[0]);
		SpreadsheetLocation end =new SpreadsheetLocation(range[1]);
	
		
		
		
		return 0.0;
	}*/
	
}
