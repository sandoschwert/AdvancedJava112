package java112.labs1;
import java.io.*;
import java.util.*;

/**
*@author sschwert
*/

public class LabSeven {
	
	//This instance variable is a list of strings
	private List<String> list;
	
	/**
	* This is main method.  It is the main entry point for the program and will
	* test the number of arguments input on the command line.
	* @param String[] args is the argument passed to the main method from the command line
	* If there is one argument it will instantiate an instance of the class and call the run method
	*/
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please enter one argument on the command line, an output file name");
		} else {
			LabSeven kumquat = new LabSeven();
			kumquat.run(args[0]);
		}	
	}
	
	
	/**
	*This is the run method, the main action of the program is done here
	*This method will instantiate the instance variable, an array list of strings
	*and add several members to the list
	*@param outputFile is the file name that is input on the command line,
	*it will be passed to the writeListToOutputFile() method
	*/
	public void run(String outputFile) {
		
		list = new ArrayList<String>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		list.add("seven");
		list.add("eight");
		list.add("nine");
		list.add("ten");
		
		writeListToOutputFile(outputFile);
		
	}
	
	/**
	*This is the writeListToOutputFile method, it will instantiate the FileWriter 
	*and do exception handling using a "try with resources" process
	*@param outputFilePath is the file name that is input on the command line
	*and passed here from the run method
	*/
	public void writeListToOutputFile(String outputFilePath) {
	
		try(PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath, false)))) {
			//this is where we write each item in the array list to the file using the FileWriter
			for (String s : list){
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
