package java112.analyzer;
import java.io.*;
import java.util.*;

/**
* The SummaryReport class will implement the Analyzer interface and print a summary report
* to a file called summary_report.text
* @author sschwert
*/

public class SummaryReport implements Analyzer {
	
	///////-----INSTANCE VARIABLES----/////////
	private int totalTokensCount;
	private Properties properties;
	
	////////-----EMPTY CONSTRUCTOR-----////////
	/**
    * empty constructor for SummaryReport class
    */
	public SummaryReport() {
  
    }
    
    ////////-----ONE PARAM CONSTRUCTOR-----////////
    /**
    * constructor for SummaryReport class calls the empty constructor
    * @param properties is a Properties object containing properties from the properties file
    */
    public SummaryReport(Properties properties) {
    	this();
        this.properties = properties;
        //works kind of like a getter/setter?
    }
	
	/**
	* The process token method is from the interface and will 
	* add tokens to the total token count
	* @param token a String that is a token from the AnalyzeFile class
	*/
	public void processToken(String token) {
		
		totalTokensCount ++;
		
	}
	
	/**
	* The writeOutputFile method is from the interface and will 
	* create a nice little summary of the file, including the token count 
	* before sorting, and send it to a new file
	* @param inputFilePath String for the input file path from the command line
	*/
	public void writeOutputFile(String inputFilePath) {
		
		String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.summary");
		
		try (PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath, false)))) {
			
			printSummaryReport(outWriter, inputFilePath);
			
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
		
	}//end writeOutputFile method
	
	/**
	* the printSummaryReport method writes the summary report to the file using 
	* the properties.getProperty method and retrieves the absolute path of the file
	* @param writer is a PrintWriter
	* @param inputFilePath is the file input from the command line
	* @exception IOException from the print writer, to be dealt with later...
	*/
	public void printSummaryReport(PrintWriter writer, String inputFilePath) throws IOException {
		//we have to create a new File object to retrieve the file path and then pass in the inputFilePath
		File newPath = new File(inputFilePath);
		
		writer.println("Application: " + properties.getProperty("application.name"));
		writer.println("Name: " + properties.getProperty("author"));
		writer.println("Email: " + properties.getProperty("author.email.address"));
		writer.println("Input file: " + newPath.getAbsolutePath()); //getAbsolutePath of the inputFilePath
		writer.println("Analyzed on: " + getDate());
		writer.println("Total token count: " + getTotalTokensCount());
	
	}
	
	///////-----GET METHODS----/////////
	/**
	*This is the get method for the instance variable
	*@return totalTokensCount an int that is the count of tokens from the file
	*/
	public int getTotalTokensCount() {
		return totalTokensCount;
	}
	
	/**
	*This is the get method for the Date string
	*@return date.ToString() a String that is the current time stamp
	*/
	public String getDate() {
		Date date = new Date(); //from java.util
		return date.toString();
	}
	
}//end of SummaryReport class
