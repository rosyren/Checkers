/**
 * This class serves as the exception type on the DoubleList Class
 * @author Rosy Ren 251080052 CS 1027
 *
 */
public class DoubleListException extends RuntimeException {
	/**
	 * constructor takes in a String input for the error message 
	 * @param input
	 */
	public DoubleListException(String input){
		// call the super-class constructor from Runtime Exception 
		super("Error: ");
		System.out.println(input);
	}
}
