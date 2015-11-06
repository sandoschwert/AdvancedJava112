package java112.analyzer;
import java.io.*;
import java.util.*;

/**
* The AnalyzeFile class contains the runAnalysis method, and calls the writeOutputFile method 
* @author sschwert
*/

public class AnalyzeFile {
	
	///////-----INSTANCE VARIABLES AND CONSTANTS-----/////////
	static final int TWO_ARGUMENTS = 2;
	///Passes test with 3 instance variables
	private ArrayList<Analyzer> analyzerObjects;
	private String inputFilePath;
	private Properties properties;
	//private String propertiesFilePath;
	//private Analyzer summaryReport;
	//private Analyzer uniqueTokenAnalyzer;
	
	/**
	* The runAnalysis method does most of the actions for the program
	* by calling the other major methods for the program
	* @param arguments is an array of Strings from the command line
	*/
	public void runAnalysis(String[] arguments) {
		
		testArguments(arguments);
		 
		inputFilePath = arguments[0];
		String propertiesFilePath = arguments[1];
		
		loadProperties(propertiesFilePath);

		createAnalyzers();
		
		readFile(inputFilePath);
		
		writeAllOutputFiles();
		
	}//end of runAnalysis method
	
	
	/**
	* the testArguments method will make sure there are only two argument 
	* entered on the command line
	* @param commandLineArgs an array of arguments from the command line
	* @return false if there are not two and only two arguments
	*/
	public boolean testArguments(String[] commandLineArgs) {
		//tests arguments, returns boolean, prints message and exits if false
		if (commandLineArgs.length != TWO_ARGUMENTS) {
			System.out.println("Please enter the input file path and the properties file path");
			System.exit(0);
			
			return false;
			
		} else {
			//right number of arguments?  good. continue.

			return true;
		}
	}
	
	/**
	* the createAnalyzers method instantiates the list of analyzerObjects which implement 
	* the Analyzer interface and passes them the properties object and puts them into an array list
	*/
	public void createAnalyzers() {
	
		analyzerObjects = new ArrayList<Analyzer>();
		
		// New way to instantiate your Analyzers
		analyzerObjects.add(new SummaryReport(properties));
		analyzerObjects.add(new UniqueTokenAnalyzer(properties));
		analyzerObjects.add(new BigWordAnalyzer(properties));
		analyzerObjects.add(new TokenCountAnalyzer(properties));
		analyzerObjects.add(new TokenSizeAnalyzer(properties));
		analyzerObjects.add(new KeywordAnalyzer(properties));

			
	}
	
	/**
	* the makeAnalyzers method instantiates the two classes that implement 
	* the Analyzer interface 
	* =====OBSOLETE====
	*/
	//public void makeAnalyzers () {
		//instantiate the analyzer instance variables
		//uniqueTokenAnalyzer = new UniqueTokenAnalyzer();
		//summaryReport = new SummaryReport();
	//}
	
	
	/**
	* the loadProperties method instantiates the properties object and loads
	* the propertiesFilePath to the getResourceAsStream method in a try/catch block
	* @param propertiesFilePath is a string representing the location of the properties file
	*/
	public void loadProperties(String propertiesFilePath) {
	
		properties = new Properties();
		
		//propertiesFilePath = "analyzer.properties";
		
		try {
			properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
			
			//for (String key: properties.stringPropertyNames()) {
			//		String value = properties.getProperty(key);
			//		System.out.println(key + " => " + value);
			//}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//DEBUG ------- System.out.println(properties);
	
	}
	
	/**
	* the makeAnalyzers method instantiates the two classes that implement the Analyzer interface
	* =====OBSOLETE====
	*/
	//public void makeAnalyzers () {
		//instantiate the analyzer instance variables
		//uniqueTokenAnalyzer = new UniqueTokenAnalyzer();
		//summaryReport = new SummaryReport();
	//}
	
	/**
	* the readFile method opens, reads, calls the splitFile method, and closes
	* the file, whose path is input at the command line
	* @param inputFilePath a String, the path of a file that is input at the command line
	*/
	public void readFile(String inputFilePath) {
	
		try (BufferedReader buffReader = new BufferedReader(new FileReader(inputFilePath))) {
			while (buffReader.ready()) { //while there is a line for me to read...
				
                splitFile(buffReader);    
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
	
	}
	
	/**
	* the splitFile method reads the file and separates all the words on non-word
	* characters ("\\W"), then calls the generate tokens method
	* @param reader is a BufferedReader
	* @exception IOException from the buffered reader, to be dealt with later...
	*/
	public void splitFile(BufferedReader reader) throws IOException {  
		String newLine = "";
		String[] tokens = null;
		
		while (reader.ready()) {
			newLine = reader.readLine();
			tokens = newLine.split("\\W");
					
			generateTokens(tokens);
        }
	}
	
	/**
	* the generateTokens method loops through the bits created from the splitFile method
	* and makes sure they aren't empty, then calls the processToken method
	* @param tokens is an array of Strings
	*/
	public void generateTokens(String[] tokens) {
		
		for (String token : tokens) {
		
			if(token.length() > 0) {

				processTokens(token);
				
			}
		}
		
	}
	
	/**
	* the processTokens method begins the token processing by calling the processToken
	* method on each analyzer in the analyzerObjects ArrayList
	* @param token is a String which is a single token from the generateTokens method
	*/
	public void processTokens(String token) {
		
		for (Analyzer newAnalyzer : analyzerObjects) {
			
			newAnalyzer.processToken(token);
			
		}
		
	}
	
	/**
	* the writeAllOutput method writes the summary files by calling the writeOutputFile
	* method on each analyzer in the analyzerObjects ArrayList and outputs a friendly messagee
	*/
	public void writeAllOutputFiles() {
		
		for (Analyzer newAnalyzer : analyzerObjects) {
			
			newAnalyzer.writeOutputFile(inputFilePath);
			
		}
		System.out.println("I made you some files!");
		
	}
	
}//end of AnalyzeFile class
