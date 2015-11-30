package java112.labs1;
import java.io.*;

/**
*@author sschwert
*@created 4/2/15
*/

public class IOExamWrite {
    /**this method is the entry point for the IOExamWrite program
    *
    *@param args command line arguments
    */
    public static void main(String[] args) {

        IOExamWrite demo = new IOExamWrite();
        demo.run();

    }//end of main method


    public void run() {
    	//this is a try with resources statment -- see? there's resources listed
    	//directly in the try statement
    	String examFile = "/home/student/output/ouput.txt";
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(examFile, true)))){
        	out.println("The final line");
        	//When writing, an IO Exception could be thrown, handle below
        } catch (IOException ioException) {
        System.out.println("There was a problem writing the file: ");
        ioException.printStackTrace();
        } catch (Exception exception) {
        	System.out.println("There was a general problem:");
        	exception.printStackTrace();
        }
    }

}//end of IOExamWrite class
