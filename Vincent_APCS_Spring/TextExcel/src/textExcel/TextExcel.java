package textExcel;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{	
		System.out.println("Hey! Welcome to NathanSpreadsheet!");
		Scanner input= new Scanner(System.in);
		Spreadsheet Nathan=new Spreadsheet();
		String command=input.nextLine();
		while (!command.equals("quit")){
			System.out.println(Nathan.processCommand(command));
			command=input.nextLine();
			// Add your command loop here
		}
	}

}
