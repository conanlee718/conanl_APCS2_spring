//Conan Lee
//APCS 2nd period
//finished date for checkpoint 1 : 3/4/17

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);				//scanner setup
		String command="";
		Spreadsheet spreadsheet=new Spreadsheet();
		System.out.print(spreadsheet.getGridText());
	    // Add your command loop here
		while(!command.equals("quit")){						//loops until "quit" is entered in console
			command=input.nextLine();
			spreadsheet.processCommand(command);
			System.out.print(spreadsheet.getGridText());
		}
	}
}
