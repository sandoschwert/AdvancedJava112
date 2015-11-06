package java112.analyzer;
import java.io.*;
import java.util.*;

/**
* The TokenSizeAnalyzer class will determine the size distribution 
* of the tokens in the input file
* @author sschwert
*/

public class TokenSizeAnalyzer implements Analyzer {
  
    // Only allowed instance variables
    private Properties properties;
    private Map<Integer, Integer> tokenSizes;
    private int maximumSize;
    
      
	////////-----EMPTY CONSTRUCTOR-----////////
	/**
    * empty constructor for TokenSizeAnalyzer class instantiates the Map
    */
	public TokenSizeAnalyzer() {
		
		tokenSizes = new TreeMap<Integer, Integer>();		
	}
	
	////////-----ONE PARAM CONSTRUCTOR-----////////
	/**
    * constructor for TokenSizeAnalyzer class calls the empty constructor
    * @param properties is a Properties object containing properties from the properties file
    */
	public TokenSizeAnalyzer(Properties properties) {
		this();
		this.properties = properties;
		
		maximumSize = 75;
    }   
        

    /**
	* The process token method is from the interface and will 
	* scan each token as it comes in, see if it is already a key in the tokenSizes
	* map and add it to the count if it is or add it to the map if it isn't
	* @param token a String that is a single token from AnalyzeFile
	*/
	public void processToken(String token) {
		
		int count = 1;
		int tokenSize = token.length();
		
		
		if (tokenSizes.containsKey(tokenSize)) {
		
			count = tokenSizes.get(tokenSize);
			count++;
			tokenSizes.put(tokenSize, count);
		
		} else {
			tokenSizes.put(tokenSize, count);
		}
	}

	
	/**
	* The writeOutputFile method is from the interface and will call the method that will
	* create a file containing a list of the different sizes of tokens represented and their occurence
	* as well as a flexible histogram representing the token size distribution
	* @param inputFilePath String for the input file path from the command line
	*/
	public void writeOutputFile(String inputFilePath) {
		
		String outputFilePathToken = properties.getProperty("output.dir") + properties.getProperty("output.file.token.size");
		
		try(PrintWriter outWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePathToken, false)))) {
			
			printTokenSize(outWriter);
			outWriter.println();
			printHistogram(outWriter);
			
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
	* This is the get method for the maximumSize instance variable
	* @return maximumSize, an int that represents the maximum possible length of asterisks (80)
	*/
	public int getMaximumSize() {
		
		return maximumSize;	
	}
	
	/**
	* This is the get method for the tokenSizes instance variable
	* @return tokenSizes, a Map that represents the length of a token as a 
	* key and the number of tokens with the key's length
	*/
	public Map<Integer, Integer> getTokenSizes() {
		
		return tokenSizes;		
	}
	
	/**
	* The findLargestValue method loops through all the entries in tokenSizes and
	* compares it to the entry in a new map, maxEntry.  If the entry in tokenSizes is larger than
	* the current entry in maxEntry then the method replaces the entry in maxEntry with the larger value
	* @return largestValue is the final value left in maxEntry after the comparison
	*/
	/*
	public double findLargestValue() {
	
		double largestValue = 0;
		
		Map.Entry<Integer, Integer> maxEntry = null; //only one entry in this array
		
		//compareTo() returns 0 if the values are equal (maxEntry stays the same)
		//returns 10 if the maxEntry value is less than the entry value (then assigns the entry to the maxEntry)
		//returns -10 if the maxEntry value is greater than the entry value (maxEntry stays the same)
		for (Map.Entry<Integer, Integer> entry : tokenSizes.entrySet()) {
			if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
			
		}
		
		largestValue = maxEntry.getValue();
		
		return largestValue;		
	}*/
	
	/**
	* the calculateScaleAmount method calls the getLargestValue method and divides the 
	* result into the maximumSize instance variable to find the scaleAmount
	* @return scaleAmount a double that will be used to make the histogram resizable
	*/
	/* I changed this based on Paula's suggestion to use Collections.max instead
		as a simpler solution than the original findLargestValue method.*/
		
	public double calculateScaleAmount() {
		
		double scaleAmount = 0;		
		
		//scaleAmount = (double)getMaximumSize()/findLargestValue();
		scaleAmount = (double)getMaximumSize()/Collections.max(tokenSizes.values());
		
		return scaleAmount;	
	}
	
	/**
	* the makeYouSeeStars method is the part I had the hardest time figuring out.
	* this is the one that made me cry in front of Debbie and question whether I was 
	* capable of being a Java developer or should just slink back to design.  Why? 
	* Because apparently this concept is super easy for some people to figure out
	* and I am not one of them... This took me almost 8 hours to figure out.
	* On the plus side, I eliminated 45 other possible methods that didn't work.
	* @return starLine a String that represents the occurence of a single entry
	*/
	public String makeYouSeeStars(double numberOfTokensInEntry) {
		
		String star = "*";
		String starLine = "";
		
		for (int i = 0; i < numberOfTokensInEntry; i++) {
			starLine += star;
		}
		
		if (numberOfTokensInEntry <= 0) {
			starLine += star;
		}
		
		return starLine;
	}
	
		
	/**
	* the printTokenCounts method writes each token and value in the map to the file
	* @param writer is a PrintWriter
	* @exception IOException from the print writer, to be dealt with later...
	*/
	public void printTokenSize(PrintWriter writer) throws IOException {

		for (Map.Entry<Integer, Integer> newToken : tokenSizes.entrySet()) {
			
			writer.println(newToken.getKey() + "\t" + newToken.getValue());

		}
	}
	
	/**
	* the printHistogram method writes each token and a line of stars representing
	* the occurence of that token
	* @param writer is a PrintWriter
	* @exception IOException from the print writer, to be dealt with later...
	*/
	public void printHistogram(PrintWriter writer) throws IOException {
		double scale = 0;
		double starNumber = 0;
		
		for(Map.Entry<Integer, Integer> newMap : getTokenSizes().entrySet()){
			
			scale = calculateScaleAmount();
			
			starNumber = (double) newMap.getValue() * scale;
			
			writer.println(newMap.getKey() + "\t" + makeYouSeeStars(starNumber));
	
		}
	}
		
}//end of TokenSizeAnalyzer class
