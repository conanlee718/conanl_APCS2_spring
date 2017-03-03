package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		String command=input.nextLine();
		Spreadsheet spreadsheet=new Spreadsheet();
		System.out.print(spreadsheet.getGridText());
	    // Add your command loop here
		while(!command.equals("quit")){
			command=input.nextLine();
			spreadsheet.processCommand(command);
		}
	}
}
