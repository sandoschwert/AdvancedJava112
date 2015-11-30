package java112.labs1;
import java.io.*;
import java.util.*;

/**
*@author sschwert
*/

public class LabEight {
	//this instance variable is a sorted set of strings
	private Set<String> set;
	/**
	* This is main method.  It is the main entry point for the program and will
	* test the number of arguments input on the command line.
	* If there is one argument it will instantiate an instance of the class and call the run method
	*/
	public static void main(String[] args) {        
		if (args.length != 1) {
			System.out.println("Please enter one argument on the command line, an output file name");
		} else {
			LabEight springtime = new LabEight();
			springtime.run(args[0]);
		}
		
	}//end of main method
	
	public void run(String outputFilePath){
		
		set = new TreeSet<String>();
		
		set.add("one");
		set.add("one");
		set.add("five");
		set.add("two");
		set.add("four");
		set.add("two");
		set.add("three");
		set.add("three");
		set.add("four");
		set.add("three");
		
		writeSetToOutputFile(outputFilePath);
	
	}//end of run method
	
	public void writeSetToOutputFile(String filePath){
		
		try(PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(filePath, false)))) {
			//this is where we write each item in the array list to the file using the FileWriter
			for (String s : set){
				outWriter.println(s);
			}
			
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Hide and seek?");
			fileNotFound.printStackTrace();
		} catch (IOException ioException) {
			System.out.println("I can't read and write good");
			ioException.printStackTrace();
		} catch (Exception exception) {
			System.out.println("Mo' code, mo' problems");
			exception.printStackTrace();
		}
	}
	
}
