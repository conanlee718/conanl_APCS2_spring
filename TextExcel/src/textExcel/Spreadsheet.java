//Conan Lee
//APCS 2nd period
//finished date for checkpoint 1 : 3/4/17

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cells;
	
	public Spreadsheet(){
		cells=new EmptyCell[getRows()][getCols()];				//setting dimensions
		
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return "";
	}

	public String cellInspection(String cellName){
		int colNum=(int)cellName.charAt(0)-(int)'A';
    	int rowNum=Integer.parseInt(cellName.substring(1))-1;
    	return cells[rowNum][colNum].fullCellText();
    	
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
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		
		String wholeSheet="";
		for(int i=0;i<cells.length;i++){
			for(int j=0;j<cells[i].length;j++){
				wholeSheet+=" ";
				wholeSheet+=cells[i][j];
			}
		}
		
		return wholeSheet;
	}

}
