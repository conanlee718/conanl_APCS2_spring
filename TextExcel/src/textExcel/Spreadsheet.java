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
		command=command.substring(0,1).toUpperCase()+command.substring(1);
		if(splitCommand[0].toUpperCase().equals("CLEAR")){
		//for loop to make everything empty cell
			if(splitCommand.length==1){
				for(int i=0;i<getRows();i++){
					for(int j=0;j<getCols();j++){
						cells[i][j]=new EmptyCell();
					}
				}
			}else{
				SpreadsheetLocation cell=new SpreadsheetLocation(splitCommand[1]);
				cells[cell.getRow()][cell.getCol()]=new EmptyCell();
			}
			return getGridText();
		}
		
		String[] threePartCommand=command.split(" ",3);
		if(command.charAt(0)>64 && command.charAt(0)<91){
			//assigning value of TextCell and printing it out on spreadsheet
			SpreadsheetLocation cell=new SpreadsheetLocation(splitCommand[0]);		//splitCommand[0] is cellName as defined in constructor of SpreadsheetLocation
			if(splitCommand[1].equals("=")){			
				cells[cell.getRow()][cell.getCol()]=new TextCell(threePartCommand[2]);
				String newSheet=this.getGridText();
				return newSheet;
			}else{
				String cellInspecContents=cells[cell.getRow()][cell.getCol()].fullCellText();
				return cellInspecContents;
			}
		}
		//Inspecting a cell
		if(splitCommand.length==1 && !command.toUpperCase().equals("CLEAR")) {		
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
