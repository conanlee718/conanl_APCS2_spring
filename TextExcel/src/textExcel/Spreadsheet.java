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
			return "";
		}
		
		String[] splitCommand=command.split(" ",3);
		if(splitCommand[0].toUpperCase().equals("CLEAR")){
		//for loop to make everything empty cell
			if(splitCommand.length==1){
			cells=new EmptyCell[getRows()][getCols()];
		
			}else{
				SpreadsheetLocation cell=new SpreadsheetLocation(splitCommand[1]);
				cells[cell.getRow()][cell.getCol()]=new EmptyCell();
			}
			return getGridText();
		}
		
		if(splitCommand[1].equals("=")){			
			//SpreadsheetLocation cell=new SpreadsheetLocation(splitCommand[0]);		//splitCommand[0] is cellName as defined in constructor of SpreadsheetLocation
			
			return getGridText();
			
			
		}
		if(splitCommand.length==1 && !command.toUpperCase().equals("CLEAR")) {		//inspection
			SpreadsheetLocation cell=new SpreadsheetLocation(command);
			Cell InspectionCell=getCell(cell);
			return(InspectionCell.fullCellText());
		}
		
		
		
								
		
		// TODO Auto-generated method stub
		return "";
	}

	
	//public String assignString(){
	//	
	//}
	
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
