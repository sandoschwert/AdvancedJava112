package java112.labs1;
import java.io.*;

/**
*@author sschwert
*@created 1/28/15
*/

public class IODemoRead {
    /**this method is the entry point for the IODemoRead program
    *
    *@param args command line arguments
    */
    public static void main(String[] args) {

        IODemoRead demo = new IODemoRead();
        demo.run();

    }//end of main method

    /**This method will read a file and write out the file contents
    *no params, no return
    */
    public void run() {
        try {
            //FileReader and BufferedReader are part of the java.io package, must import java.io package to use
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            //create a holding place for one line of text in the file
            String line = null;

            while (reader.ready()) { //while there is a line for me to read...
                line = reader.readLine(); //ready() and readLine() are both methods from BufferedReader
                System.out.println(line);
            }

        } catch(FileNotFoundException fileNotFound) {
            System.out.println("File not found");
            fileNotFound.printStackTrace();
        } catch(IOException ioException) {
            System.out.println("There was a problem reading the file");
            ioException.printStackTrace();
        }
    }

}//end of IODemoRead class
