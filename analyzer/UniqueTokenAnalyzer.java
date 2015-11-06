package java112.analyzer;
import java.io.*;
import java.util.*;

/**
* The UniqueTokenAnalyzer class will implement the Analyzer interface and put each
* token into the TreeSet, then print each unique token to a file along with the count
* of all the tokens in the TreeSet
* @author sschwert
*/

public class UniqueTokenAnalyzer implements Analyzer {
	
	///////-----INSTANCE VARIABLES----/////////
	private Set<String> uniqueTokensList;
	private Properties properties;

	////////-----EMPTY CONSTRUCTOR-----////////
	/**
    * empty constructor for UniqueTokenAnalyzer class instantites the uniqueTokensList TreeSet
    */
	public UniqueTokenAnalyzer() {
		
		uniqueTokensList = new TreeSet<String>();
		
	}
    
    ////////-----ONE PARAM CONSTRUCTOR-----////////
    /**
    * constructor for UniqueTokenAnalyzer class calls the empty constructor
    * @param properties is a Properties object containing properties from the properties file
    */
    public UniqueTokenAnalyzer(Properties properties) {
    	this();
        this.properties = properties;
    }
	

	
	/**
	* The process token method is from the interface and will 
	* add tokens to the uniqueTokenList
	* @param token a String that is a single token from AnalyzeFile
	*/
	public void processToken(String token) {
		
		uniqueTokensList.add(token);
		
	}
	
	/**
	* The writeOutputFile method is from the interface and will call the method that will
	* create a file containing all of the unique words from the file and display their count
	* @param inputFilePath String for the input file path from the command line
	*/
	public void writeOutputFile(String inputFilePath) {
		
		String outputFilePathToken = properties.getProperty("output.dir") + properties.getProperty("output.file.unique");
		
		try(PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePathToken, false)))) {
			
			printUniqueTokens(outWriter);
			
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
	* the printUniqueTokens method writes each token in the uniqueTokensList to the file
	* @param writer is a PrintWriter
	* @exception IOException from the print writer, to be dealt with later...
	*/
	public void printUniqueTokens(PrintWriter writer) throws IOException {
		
		for (String token : uniqueTokensList){ 
				writer.println(token);
			}
			
		System.out.println("Total Unique Tokens: " + getUniqueTokensCount());
	}
	
	///////-----GET METHODS----/////////
	/**
	*This is the get method for the uniqueTokensList instance variable
	*@return uniqueTokensList a Set that is the list of unique tokens from the file
	*/
	public Set getUniqueTokensList() {
		return uniqueTokensList;
	}
	
	/**
	*This is the get method for the count of all the unique tokens
	*@return uniqueTokensCount which is the count of the items in the TreeSet uniqueTokensList
	*/
	public int getUniqueTokensCount() {
		
		int uniqueTokensCount = 0;
		
		for (String token : uniqueTokensList) {
			uniqueTokensCount ++;
		}
		
		return uniqueTokensCount;
	}
	
}//end of UniqueTokenAnalyzer class
