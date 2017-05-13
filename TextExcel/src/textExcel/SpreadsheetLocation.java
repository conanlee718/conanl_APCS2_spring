//Conan Lee
//APCS 2nd period
//finished date for checkpoint 1 : 3/4/17

package textExcel;
import java.util.Scanner;
//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int rowNum;
	private int colNum;
	private String cellName;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return rowNum;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return colNum;
    }
    
    public SpreadsheetLocation(String cellName){
    	
        // TODO: Fill this out with your own code
    	colNum=(int)cellName.toUpperCase().charAt(0)-(int)'A';
    	rowNum=Integer.parseInt(cellName.substring(1))-1;
    }

}
