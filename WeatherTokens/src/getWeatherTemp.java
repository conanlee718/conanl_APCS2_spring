import java.io.*;
import java.util.*;
public class getWeatherTemp {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new   File("./data/weather.txt"));
		double current=input.nextDouble();
		for(int i=0;i<6;i++){
			double day2=input.nextDouble();
			System.out.println(current+" to "+day2+", change: "+(day2-current));
			current = day2;
		}
	}
}