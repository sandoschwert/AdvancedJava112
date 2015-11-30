package java112.analyzer;
import java.io.*;
import java.util.*;

/**
* The Keyword Analyzer Class will determine where keywords are in the input file.
* @author sschwert
*/

public class KeywordAnalyzer implements Analyzer {
	
	// Only allowed instance variables
	private Map<String, List<Integer>> keywordMap;	
	private Properties properties;
	private int tokenOccurence;
	
	
	
	//////////----------EMPTY CONSTRUCTOR----------//////////
	/**
	* empty constructor for KeywordAnalyzer class instantiates the TreeMap
	*/
	public KeywordAnalyzer() {
		
		keywordMap = new TreeMap<String, List<Integer>>();
		
		tokenOccurence = 0;
		
	}
	
	//////////----------ONE PARAM CONSTRUCTOR----------//////////
	/**
	* constructor for KeywordAnalyzer class calles the empty constructor
	* @param properties is a Properties object containing properties from the properties file
	*/
	public KeywordAnalyzer(Properties properties) {
		this();
		this.properties = properties;
		
		readKeywordFile();
	}
	
	/**
	* The process token method is from the interface and will test the tokens/words
	* as they arrive from AnalyzeFile and check to see if it is one of the keywords
	* in the properties file and put it into and Arraylist
	* and call the determinePosition() method
	* @param word a String that is a single token from AnalyzeFile
	*/
	public void processToken(String token) {
		
		List<Integer> occurences = new ArrayList<Integer>();
		/*as each token comes in - count it to represent position in file*/
		tokenOccurence++; 
		
		if(keywordMap.containsKey(token)) {
			
			keywordMap.get(token).add(tokenOccurence);
			occurences.add(tokenOccurence);

		}

	}
	
	/**
	* the readKeywordFile method opens, reads, calls the splitFile method, and closes
	* the properties file which contains a list of keywords
	* Then calls the generateKeywords method and passes it each new keyword
	* @param inputFilePath a String, the path of a file that is input at the command line
	*/
	public void readKeywordFile() {
		
		String newLine = "";
		String[] keywords = null;
		String inputFilePath = properties.getProperty("file.path.keywords");
		
		try (BufferedReader buffReader = new BufferedReader(new FileReader(inputFilePath))) {
			while (buffReader.ready()) { //while there is a line for me to read...
				
                newLine = buffReader.readLine();
                keywords = newLine.split("\\W");
					
				generateKeywords(keywords);
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
	* the generateKeywords method tests whether the keyword exitsts and 
	* adds the keyword (as a key) and a new empty ArrayList (as a value) to the keywordMap
	* @param keywords is an array of Strings that holds keywords from the readKeywordFile method
	*/
	public void generateKeywords(String[] keywords) {
		
		List<Integer> occurenceList;
		
		for (String keyword : keywords) {

			if(keyword.length() > 0) {
				occurenceList = new ArrayList<Integer>();
				keywordMap.put(keyword, occurenceList);
			}
		}
		
	}
	

	/**
	* The writeOutputFile method is from the interface and will call the method that will
	* call the printKeywordReport method which creates a file containing a 
	* report of each keyword and where it occurs in the file
	* The output file path is obtained from the properties file
	* @param inputFilePath String for the input file path from the command line
	*/
	public void writeOutputFile(String inputFilePath) {
		
		String outputFilePathToken = properties.getProperty("output.dir") + properties.getProperty("output.file.keyword");
		
		try(PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePathToken, false)))) {
			
			printKeywordReport(outWriter);
			
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
	* This is the get method for the keywordMap instance variable
	* @return keywordMap, a Map that represents the keyword and where it occurs in the input file
	*/
	public Map<String, List<Integer>> getKeywordMap() {
	
		return keywordMap;
		
	}
	
	/*
		The printKeyordReport method is what I have updated after suggestions from 
		Paula.  Although, the actual suggestion was to refactor the buildOutput method
		(commented out below) so that the program would write the ouput one line
		at a time to keep from binding up when presented with large amounts of data.
		I know that this would be better if it were broken out but I honestly 
		couldn't figure out how write the internal loop as it's own method and 
		still write one line at a time.  Bugger.
	*/
	
	/**
	* the printKeywordReport method formats the output, loops through the map one
	* entry at a time writes the keyword to the output file, and for each time through 
	* loops through the arrayLists (map values) and outputs each token entry occurence
	* one at a time so that the program doesn't have to save the output in memory
	* before writing it.
	* @param writer is a PrintWriter
	* @exception IOException from the print writer, to be dealt with later...
	*/
	public void printKeywordReport(PrintWriter writer) throws IOException {
		String beginValueList = "[";
		String endValueList = "]";
		String newValueList = "";
		String comma = ", ";
		int index = 0;
		int lineWidth = 0;
		List<Integer> valueList = new ArrayList<Integer>(); 
		
		
		
		for (Map.Entry<String, List<Integer>> newMap : getKeywordMap().entrySet()) {
			
			writer.print(newMap.getKey() + " =" + System.lineSeparator());
			writer.print(beginValueList);
			valueList = newMap.getValue();
			index = 0;
			
			
			for (int value : valueList) {
				
				if(lineWidth < 10) {	
					
					if(index < valueList.size() - 1) {
						comma = ", ";	
					} else {
						comma = "";
					}
					writer.print(value + comma);
					lineWidth++;

				} else {
					lineWidth = 0;
					writer.print(System.lineSeparator());

				}
				
				index++;
				
			}
	
			writer.print(endValueList);

			writer.println(System.lineSeparator());
			
		}
		
	}
	
/* SOME OF MY MANY ATTEMPTS --------------->
	/**
	* the buildOutput method took me quite a while to figure out.  I was really 
	* committed to using the modulus operator to crop each row evenly and committed
	* probably over 6 hours to that endeavor.  Finally Trisha helped me come up with
	* this method of building the output in pieces, rather than splitting the valueList
	* @param valueList is a list of integers that represents where each keyword occurs in the input file
	* @return newOutput is a String represents the output for a single keyword
	*/
	

/*	public String buildOutput(List<Integer> valueList) {
		
		String newValueList = "";
		String comma = "";
		int index = 0;
		int lineWidth = 0;
		
		for (int value : valueList) {			
		
			if(lineWidth < 9) {
				lineWidth++;
			} else {
				lineWidth = 0;
				newValueList += System.lineSeparator();//this is where the next line starts
				//newValueList = "";
			}
			
			if(index < valueList.size() - 1) {
				newValueList += value + ", ";
			} else {
				newValueList += value;
			}
			
			index++;
			
		}
		
		return newValueList;	
	}
	
	/*
	
	public void printKeywordReport(PrintWriter writer) throws IOException {
		
		
		for (Map.Entry<String, List<Integer>> newMap : getKeywordMap().entrySet()) {
			
			writer.println(newMap.getKey() + " =" + System.lineSeparator());
			writer.println(buildOutput(newMap.getValue()));
			writer.println();
			
		}
		
	}
	
	public String buildOutput(List<Integer> valueList) {
		
		String beginValueList = "[";
		String endValueList = "]";
		String newValueList = "";
		String newOutput = "";
		String comma = "";
		int index = 0;
		int lineWidth = 0;
		
		for (int value : valueList) {
			
			newOutput += beginValueList;
			
			if(index < valueList.size() - 1) {
				comma = ", ";
			} else {
				comma = "";
			}
			
			if(lineWidth < 9) {
				
				lineWidth++;
				newOutput += value;
				newOutput += comma;
				
			} else {
				
				lineWidth = 0;
				newOutput += System.lineSeparator();
				newOutput += value;
				newOutput += comma;
				
			}

			index++;
			
		}
		
		//newOutput = beginValueList + newValueList + endValueList;
		
		return newOutput;	
	}
	*/


}//end of KeywordAnalyzer class