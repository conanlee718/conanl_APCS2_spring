//Conan Lee
//APCS 2nd period
//finished date for checkpoint 1 : 3/4/17

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cells;
	
	public Spreadsheet(){
		cells=new Cell[getRows()][getCols()];				//setting dimensions
		for(int i=0;i<cells.length;i++){					//for loop to make each cell an EmptyCell
			for(int j=0;j<cells[i].length;j++){
				cells[i][j]=new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
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
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		String str="Apple Banana Orange";
		String[] arr=str.split(" ");
		String wholeSheet="";
		for(int i=0;i<str.length();i++){
			wholeSheet+=arr[i];
		}
		
		return wholeSheet;
	}

}
