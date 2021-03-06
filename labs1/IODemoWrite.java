package java112.labs1;
import java.io.*;

/**
*@author sschwert
*@created 2/4/15
*/

public class IODemoWrite {
    /**this method is the entry point for the IODemoRead program
    *
    *@param args command line arguments
    */
    public static void main(String[] args) {

        IODemoWrite demo = new IODemoWrite();
        demo.run();

    }//end of main method

    /**This method will read a file and write out the file contents
    *no params, no return
    */
    public void run() {
    	//this is a try with resources statment -- see? there's resources listed
    	//directly in the try statement
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("foo.out")))){
        	out.println("Some stuff on the first line");
        	out.println("Some more stuff");
        	//When writing, an IO Exception could be thrown, handle below
        } catch (IOException ioException) {
        System.out.println("There was a problem writing the file: ");
        ioException.printStackTrace();
        } catch (Exception exception) {
        	System.out.println("There was a general problem:");
        	exception.printStackTrace();
        }
    }

}//end of IODemoRead class
