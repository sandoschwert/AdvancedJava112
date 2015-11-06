package java112.labs1;

/**
*@author sschwert
*@created 1/28/15
*/

public class LabThree {
    /** This method serves as the entry point for Lab 3.
    * This method will check for the proper number of arguments and call run()/
    *
    *@param args The command line argumetns
    */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please enter one argument on the command line");
        } else {

            LabThree lab = new LabThree();
            lab.run(args[0]);
        }
    }

    /** This method will write out whatever String is passed in.
    *
    *@param inputText The String which will print out
    */
    public void run(String test) {
        System.out.println("input: " + test);
    }

}
