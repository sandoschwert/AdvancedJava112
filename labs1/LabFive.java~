package java112.labs1;
import java.io.*;

/**
*@author sschwert
*@created 2/4/15
*/

public class LabFive {
	/**This method serves as the entry point for Lab 5.
	* This method will check for the proper number of arguments and call run()
	*
	*/
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Please enter two arguments on the command line, a file name and a message");
		} else {
			LabFive turtle = new LabFive();
			turtle.run(args[0], args[1]);
		}	
	}//end of the main method
	
	public void run(String fileName, String message) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))){
			out.println(message);
		} catch (IOException ioException) {
			System.out.println("There was a problem writing the file: ");
			ioException.printStackTrace();
		} catch (Exception exception) {
			System.out.println("There was a general problem: ");
			exception.printStackTrace();		
		}
	}
	
}
