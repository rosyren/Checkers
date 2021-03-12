/**
 * This serves as an exception to catch game related exceptions 
 * @author Rosy Ren 251080052 CS 1027
 *
 */
public class GameException extends RuntimeException {
	/**
	 * This takes in a string parameter and returns an error message
	 * @param input
	 */
	public GameException(String input) {
		// call the super-class's constructor
		super("Error: ");
		System.out.println(input);
	}
}
