package java112.analyzer;
import java.io.*;
import java.util.*;

/**
* The AnalyzerDriver class will instantiate an instance of the 
* project’s main processing class and begin the analyzing process     
* @author sschwert
*/

public class AnalyzerDriver {
	
	/** 
	* This is the main method it is the entrance point for the program
	* The main method will instantiate the AnalyzeFile class which has the main processig method
	* @param args which is a String array of the command line arguments
	*/
	public static void main(String[] args) {
		//create a new instance of an AnalyzeFile object and call the runAnalysis method
		//passing it the command line arguments
		AnalyzeFile analyzer = new AnalyzeFile();
		
			analyzer.runAnalysis(args);
		
	}//end of main method
	
}//end of AnalyzerDriver class
