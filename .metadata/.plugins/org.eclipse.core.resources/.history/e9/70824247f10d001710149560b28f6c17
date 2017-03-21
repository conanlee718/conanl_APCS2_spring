//Conan Lee
//APCS 2nd period
//finished date for checkpoint 1 : 3/4/17

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cells;
	
	public Spreadsheet(){
		cells=new Cell[getRows()][getCols()];
		for(int i=0;i<getRows();i++){
			for(int j=0;j<getCols();j++){
				cells[i][j]=new EmptyCell();
			}
		}
		
	}
	
	@Override
	public String processCommand(String command)
	{
		if(command.equals("")){
			return command;
		}
		
		String[] splitCommand=command.split(" ");
		//for clearing whole spreadsheet or individual cell
		if(splitCommand[0].toUpperCase().equals("CLEAR")){
		//for loop to make everything empty cell
			if(splitCommand.length==1){
				for(int i=0;i<getRows();i++){
					for(int j=0;j<getCols();j++){
						cells[i][j]=new EmptyCell();
					}
				}
			}else{		//only one designated cell gets cleared
				splitCommand[1]=splitCommand[1].toUpperCase(); //because splitCommand[1] might be a1, which is lower case
				SpreadsheetLocation low= new SpreadsheetLocation(splitCommand[1]);
				cells[low.getRow()][low.getCol()]=new EmptyCell();
			}
			return getGridText();
		}
		
		
		String[] threePartCommand=command.split(" ",3); //split to 3 because the value assigned or trying to be assigned to cell may have spaces. 
		command=command.substring(0, 1).toUpperCase()+command.substring(1);
		
		if(command.charAt(0)>(int)'A'-1 && command.charAt(0)<(int)'L'+1){
			//Inspecting cell
			SpreadsheetLocation cell=new SpreadsheetLocation(splitCommand[0].toUpperCase());		//splitCommand[0] is cellName as defined in constructor of SpreadsheetLocation
			if(splitCommand.length==1){
				String cellInspecContents=cells[cell.getRow()][cell.getCol()].fullCellText();
				return cellInspecContents;
			}
			//assigning TextCell to spreadsheet and then returning it
			if(splitCommand.length>1){			
				if(threePartCommand[1].equals("=")){			
					if(threePartCommand[2].charAt(0)=='"'){
						cells[cell.getRow()][cell.getCol()]=new TextCell(threePartCommand[2]);
						String newSheet=this.getGridText();
						return newSheet;
					}
					else if(command.charAt(command.length()-1)=='%'){
						cells[cell.getRow()][cell.getCol()]=new PercentCell(threePartCommand[2]);
						String newSheet=this.getGridText();
						return newSheet;
					}
					else if(command.charAt(0)=='('){
						cells[cell.getRow()][cell.getCol()]=new FormulaCell(threePartCommand[2]);
						String newSheet=this.getGridText();
						return newSheet;
					}else{
						cells[cell.getRow()][cell.getCol()]=new ValueCell(threePartCommand[2]);
						String newSheet=this.getGridText();
						return newSheet;
					}
				}	
				
			}
			
		}
		
			
		
		// TODO Auto-generated method stub
		return "";
	}


	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub 
		int row=loc.getRow();
		int col=loc.getCol();
		
		return(cells[row][col]);
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		String firstHeader="   |";
		String spreadsheet="";
	
		
		for(int col=0;col<this.getCols();col++){
			firstHeader+=((char)('A'+col))+"         |";
		}
		spreadsheet+=firstHeader + "\n";
		String rows="";
		for(int row=0;row<getRows();row++){
			if(row<9){
				rows=((row+1)+"  |");
			}else{
				rows=((row+1)+" |");
			}
			for(int cell=0;cell<cells[0].length;cell++){
				rows+=cells[row][cell].abbreviatedCellText() +"|";
			}
			spreadsheet+=rows+ "\n";
		}
		// TODO Auto-generated method stub
		return spreadsheet;
		
		
	}
}
