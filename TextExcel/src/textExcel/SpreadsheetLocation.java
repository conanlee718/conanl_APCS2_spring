//Conan Lee
//APCS 2nd period
//finished date for checkpoint 1 : 3/4/17

package textExcel;
import java.util.Scanner;
//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        Scanner rows=new Scanner(System.in);				//scanner for number of rows
        int rowNumber=rows.nextInt();
        return rowNumber;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        Scanner columns=new Scanner(System.in);				//scanner for number of columns
        int colNumber=columns.nextInt();
        return colNumber;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	
        // TODO: Fill this out with your own code
    }

}
