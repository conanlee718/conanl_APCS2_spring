package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cells;
	
	public Spreadsheet(){
		cells=new Cell[getRows()][getCols()];
		for(int i=0;i<cells.length;i++){
			for(int j=0;j<cells[i].length;j++){
				cells[i][j]=new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

}