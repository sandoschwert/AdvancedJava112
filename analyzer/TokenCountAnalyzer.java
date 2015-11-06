package java112.analyzer;
import java.io.*;
import java.util.*;

/**
* The Token Count Analyzer class will count and output the number of unique tokens
* by 
* @author sschwert
*/

public class TokenCountAnalyzer implements Analyzer {
  
     
    // Only allowed instance variables
    private Properties properties;
    private Map<String, Integer> tokenCounts;
    
    ////////-----EMPTY CONSTRUCTOR-----////////
    /**
    * empty constructor for TokenCountAnalyzer class instantiates the TreeMap
    */
	public TokenCountAnalyzer() {
		
		tokenCounts = new TreeMap<String, Integer>();
		
	}
	
	////////-----ONE PARAM CONSTRUCTOR-----////////
	/**
    * constructor for TokenCountAnalyzer class calls the empty constructor
    * @param properties is a Properties object containing properties from the properties file
    */
	public TokenCountAnalyzer(Properties properties) {
		this();
		this.properties = properties;
        }
  
  
    
    /**
	* The process token method is from the interface and will 
	* scan each token as it comes in, see if it is already a key in the tokenCounts
	* map and add it to the count if it is or add it to the map if it isn't
	* @param token a String that is a single token from AnalyzeFile
	*/
	public void processToken(String token) {
		
		int count = 1;
		
		if (tokenCounts.containsKey(token)) {
		
			count = tokenCounts.get(token);
			count++;
			tokenCounts.put(token, count);
		
		} else {
			tokenCounts.put(token, count);
		}
		
		
	}
	
	/**
	* The writeOutputFile method is from the interface and will call the method that will
	* create a file containing all of the keys ands values from the map of tokens and counts
	* @param inputFilePath String for the input file path from the command line
	*/
	public void writeOutputFile(String inputFilePath) {
		
		String outputFilePathToken = properties.getProperty("output.dir") + properties.getProperty("output.file.token.count");
		
		try(PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePathToken, false)))) {
			
			printTokenCounts(outWriter);
			
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
	
	/**
	* the printTokenCounts method writes each token and value in the map to the file
	* @param writer is a PrintWriter
	* @exception IOException from the print writer, to be dealt with later...
	*/
	public void printTokenCounts(PrintWriter writer) throws IOException {
		//I don't know what .entrySet really does, I found it on stack overflow
		//It's calling each key, value pair as a unit, one at a time...
		for (Map.Entry<String, Integer> newToken : tokenCounts.entrySet()) {
			
			writer.println(newToken.getKey() + "\t" + newToken.getValue());
		
		}
	}
	
	///////-----GET METHODS----/////////
	/**
	*This is the get method for the uniqueTokensList instance variable
	*@return tokenCounts a Map that is the list of unique tokens and their count
	*/
	public Map getTokenCounts() {
        return tokenCounts;
    }
  
	
}
