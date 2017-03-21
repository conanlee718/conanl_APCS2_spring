//Conan Lee
//APCS 2nd period
//finished date for checkpoint 1 : 3/4/17

package textExcel;

import java.io.FileNotFoundException;
import java.io.*;
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
			String[]splitCommand=command.split(" ");
			if(splitCommand.length>1){
				System.out.print(spreadsheet.getGridText());
			}else{
				System.out.println(spreadsheet.processCommand(command));
			}
		}
	}
	
	
}
