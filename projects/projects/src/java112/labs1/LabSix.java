package java112.labs1;
import java.io.*;

/**
*@author sschwert
*@created 2/5/15
*/

public class LabSix {
	/**This method serves as the entry point for Lab 6.
	* This method will check for the proper number of arguments and call run()
	*
	*/
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Please enter two arguments on the command line, an input file name and an output file name");
		} else {
			LabSix iguana = new LabSix();
			iguana.run(args[0], args[1]);
		}	
	}//end of the main method\
	
	public void run(String inputFilePath, String outputFilePath) {
		String line = null;
		
		try(BufferedReader buffReader = new BufferedReader(new FileReader(inputFilePath)); 
			PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter("src/" + outputFilePath, true)))) {
				while (buffReader.ready()) {
					line = buffReader.readLine();
					outWriter.println(line);
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
		
	}//ends run method
	
}
