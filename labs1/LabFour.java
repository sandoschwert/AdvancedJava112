package java112.labs1;
import java.io.*;

/**
*@author sschwert
*@created 1/28/15
* this code shows the try with resources method as compared to the previous way of doing things
*/

public class LabFour {
	/**This method serves as the entry point for Lab 4.
	*/
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please enter one argument on the command line");
		} else {
		
			LabFour yoda = new LabFour();
			yoda.run(args[0]);
		}
		
	}
	
	public void run(String input){

		//Code rewritten using "try with resources", see original code below
		String line = null;
		
		try (BufferedReader buffReader = new BufferedReader(new FileReader("input.txt"))) {
			while (buffReader.ready()) { //while there is a line for me to read...
				line = buffReader.readLine();
                System.out.println(line);
            }
		} catch(FileNotFoundException fileNotFound) {
			System.out.println("Where's yer file?");
			fileNotFound.printStackTrace();
		} catch(IOException ioException) {
			System.out.println("Yer file tengo problemos");
			ioException.printStackTrace();
		} catch(Exception exception) {
			System.out.println("Mo' code, mo' problems");
			exception.printStackTrace();
		}
		
	/*	
		FileReader fileReader = null;
		BufferedReader reader = null;
		
		//create a holding place for one line of text in the file
		String line = null;
		
		try {
			//FileReader and BufferedReader
			fileReader = new FileReader("input.txt");
			reader = new BufferedReader(fileReader);
		
			while (reader.ready()) {
				line = reader.readLine();
				//write out the string representing the line you just read
				System.out.println(line);
			}
			
		} catch(FileNotFoundException fileNotFound) {
			System.out.println("Where's yer file?");
			fileNotFound.printStackTrace();
		} catch(IOException ioException) {
			System.out.println("Yer file tengo problemos");
			ioException.printStackTrace();
		} catch(Exception exception) {
			System.out.println("Mo' code, mo' problems");
			exception.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException ioException) {
				System.out.println("Yer file won't close, bro");
				ioException.printStackTrace();
			} catch(Exception exception) {
				System.out.println("Mo' code, mo' problems");
				exception.printStackTrace();
			} 
		}
		*/
		
		
	}
}
