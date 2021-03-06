package textExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// Update this file with your own code.

public class Spreadsheet implements Grid
{	
	private Cell[][] excel= new Cell[this.getRows()][this.getCols()];
	public Spreadsheet(){
		for (int i=0;i<excel.length;i++){
			for (int j=0;j<excel[i].length;j++)
				excel[i][j]=new EmptyCell();
		}
	}

	public String processCommand(String command)
	{	
		if(command.equals(""))
			return command;
		//clear
		if (command.toUpperCase().equals("CLEAR")){
			for (int i=0;i<excel.length;i++){
				for (int j=0;j<excel[i].length;j++)
					excel[i][j]=new EmptyCell();
			}
			return this.getGridText();
		}
		//clear a cell
		if (command.toUpperCase().startsWith("CLEAR")){
			excel[Integer.parseInt(command.substring(7))-1][command.toUpperCase().charAt(6)-65] = new EmptyCell();
			return this.getGridText();
		}
		command=command.substring(0,1).toUpperCase()+command.substring(1);
		//saving
		if(command.startsWith("Save")&&command.endsWith(".csv")||command.startsWith("save"))
			return writingToFile(command.substring(command.indexOf(' ')+1));
		//opening
		if(command.startsWith("Open")&&command.endsWith(".csv")||command.startsWith("open"))
			return readingFromFile(command.substring(command.indexOf(' ')+1));

		if (command.charAt(0)>64&&command.charAt(0)<91){
			//inspection
			if(command.indexOf('=')==-1){
				String cellValue=excel[Integer.parseInt(command.substring(1))-1][command.charAt(0)-65].fullCellText();
				return cellValue;
			}	
			//assignment of TextCell
			if (command.indexOf('=')!=-1 && command.indexOf('"')!=-1){
				if(command.charAt(2)==' ')
					excel[Integer.parseInt(command.substring(1,2))-1][command.charAt(0)-65]=new TextCell(command.substring(command.indexOf('"')+1,command.lastIndexOf('"')));
				else
					excel[Integer.parseInt(command.substring(1,3))-1][command.charAt(0)-65]=new TextCell(command.substring(command.indexOf('"')+1,command.lastIndexOf('"')));
				String newSpreadsheet = this.getGridText();
				return newSpreadsheet;
			}
			//assignment of FormulaCell
			else if(command.indexOf('=')!=-1 && command.indexOf("(")!=-1&&command.indexOf(")")!=-1){
				if(command.charAt(2)==' ')
					excel[Integer.parseInt(command.substring(1,2))-1][command.charAt(0)-65]=new FormulaCell(command.substring(command.indexOf('('),command.lastIndexOf(')')+1), this);
				else
					excel[Integer.parseInt(command.substring(1,3))-1][command.charAt(0)-65]=new FormulaCell(command.substring(command.indexOf('('),command.lastIndexOf(')')+1), this);
				String newSpreadsheet = this.getGridText();
				return newSpreadsheet;
			}
			//assignment of ValueCell
			else if(command.indexOf('=')!=-1 && command.indexOf("(")==-1&&command.indexOf(")")==-1&&command.indexOf("%")==-1){
				if(command.charAt(2)==' ')
					excel[Integer.parseInt(command.substring(1,2))-1][command.charAt(0)-65]=new ValueCell(command.substring(command.indexOf('=')+2));
				else
					excel[Integer.parseInt(command.substring(1,3))-1][command.charAt(0)-65]=new ValueCell(command.substring(command.indexOf('=')+2));
				String newSpreadsheet = this.getGridText();
				return newSpreadsheet;}
			//assignment of PercentCell
			else if(command.indexOf('=')!=-1 && command.indexOf("(")==-1&&command.indexOf(")")==-1&&command.indexOf("%")!=-1){
				if(command.charAt(2)==' ')
					excel[Integer.parseInt(command.substring(1,2))-1][command.charAt(0)-65]=new PercentCell(command.substring(command.indexOf('=')+2));
				else
					excel[Integer.parseInt(command.substring(1,3))-1][command.charAt(0)-65]=new PercentCell(command.substring(command.indexOf('=')+2));
				String newSpreadsheet = this.getGridText();
				return newSpreadsheet;}
		}

		return command;
	}

	public int getRows()
	{
		return 20;
	}

	public int getCols()
	{
		return 12;
	}

	public Cell getCell(Location loc)
	{
		return excel[loc.getRow()][loc.getCol()];
	}

	public String getGridText()
	{
		String grid="   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |"+"\n";
		for (int i=0;i<this.getRows();i++){
			if(i<9)
				grid=grid+(i+1)+"  ";
			else
				grid=grid+(i+1)+" ";
			for (int j=0;j<this.getCols();j++){
				grid=grid+"|"+ excel[i][j].abbreviatedCellText();
			}
			grid=grid+"|\n";
		}

		return grid;
	}
	private String writingToFile (String filename){ 
		PrintStream outputFile;
		try {
			outputFile = new PrintStream(new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		for (int i=0;i<excel.length;i++){
			for (int j=0;j<excel[i].length;j++){
				char letter= (char) (j + 65);
				if(excel[i][j] instanceof ValueCell)
					outputFile.println(letter+""+(i+1)+","+"ValueCell"+","+excel[i][j].fullCellText());
				else if(excel[i][j] instanceof PercentCell)
					outputFile.println(letter+""+(i+1)+","+"PercentCell"+","+excel[i][j].fullCellText());
				else if(excel[i][j] instanceof FormulaCell)
					outputFile.println(letter+""+(i+1)+","+"FormulaCell"+","+excel[i][j].fullCellText());
				else if(excel[i][j] instanceof TextCell)
					outputFile.println(letter+""+(i+1)+","+"TextCell"+","+excel[i][j].fullCellText());
			}
		}
		outputFile.close();
		return this.getGridText();
	}
	private String readingFromFile(String filename){
		Scanner inputFile;
		try {
			inputFile = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		while(inputFile.hasNextLine()){
			String data=inputFile.nextLine();
			String cellIdentifier=data.substring(0,data.indexOf(','));
			String cellType=data.substring(data.indexOf(',')+1,data.lastIndexOf(','));
			String cellValue=data.substring(data.lastIndexOf(',')+1);
			if(cellType.equals("ValueCell"))
				excel[Integer.parseInt(cellIdentifier.substring(1))-1][cellIdentifier.charAt(0)-65]= new ValueCell(cellValue);
			else if(cellType.equals("PercentCell"))
				excel[Integer.parseInt(cellIdentifier.substring(1))-1][cellIdentifier.charAt(0)-65]= new PercentCell(Double.parseDouble(cellValue)*100+"%");
			else if(cellType.equals("FormulaCell"))
				excel[Integer.parseInt(cellIdentifier.substring(1))-1][cellIdentifier.charAt(0)-65]= new FormulaCell(cellValue);
			else if(cellType.equals("TextCell"))
				excel[Integer.parseInt(cellIdentifier.substring(1))-1][cellIdentifier.charAt(0)-65]= new TextCell(cellValue.substring(1,cellValue.length()-1));
		}
		inputFile.close();
		return this.getGridText();
	}

}
