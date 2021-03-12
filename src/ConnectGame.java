
/**
 * this class represents the logic and game structure for Connect four
 * @author Rosy Ren (251080052) CS 1027
 *
 */
public class ConnectGame {
	/**
	 * declaring the variables
	 * matrix for the general structure of the game board
	 * the WIDTH and HEIGHT of the game board 
	 * the visual component 
	 * and whether or not the game is finished  
	 */
	private DoubleList <DoubleList<String>> matrix;
	private final int WIDTH = 7;
	private final int HEIGHT = 6;
	private GUI gui;
	private boolean isGameActive;
	int counter = 0; 
	
	
	/**
	 * initializes the matrix with "empty" in all of the slots 
	 * set the isGameActive to true 
	 */
	public ConnectGame() {
		
		matrix = new DoubleList <DoubleList<String>>();
		
		// goes through the entire matrix per row initalizing it to "empty"
		for (int i = 0; i < HEIGHT; i ++) {
			DoubleList<String> willAdd = new DoubleList<String>();
			for (int j = 0; j < WIDTH; j ++) {
				willAdd.addToRear("empty");
			}
			// adding to the row list 
			matrix.addToRear(willAdd);
	
		}
		isGameActive = true;
	}
	
	/**
	 * initialize the gui to a new GUI object with the rows and columns of the game board
	 */
	public void addGUI() {
		GUI gui = new GUI(HEIGHT, WIDTH);
		
	}
	
	/**
	 * takes in a String parameter of the colour
	 * if it has met the win conditions calling the other four methods
	 * @param colour
	 * @return boolean	 true if it is won
	 */
	
	public boolean checkWin(String colour) {
		Boolean win = false;
		isGameActive = true;
		
		boolean horz = checkHorizontal(colour);
		boolean vert = checkVertical(colour);
		boolean diaup = checkDiagonalUp(colour);
		boolean diadown = checkDiagonalDown(colour);
		
		//System.out.println(horz);
		//System.out.println(vert);
		//System.out.println(diaup);
		//System.out.println(diadown);
		
		// if either horizontal, vertical, or either diagonal are true then it will indicate the user has won 
		if ( horz || vert || diaup || diadown) {
			win = true;
			isGameActive = false;
			//print();
			
			
		}
		return win;
		
	}
	/**
	 * check if there are 4 consecutive checkers of the same colour 
	 * @param colour
	 * @return boolean 		true if there is a horizontal win 
	 */
	private boolean checkHorizontal(String colour) {
		this.counter++; 
		int count = 0;
		
		// go into each row 
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {

				// if there is an element that matches the input colour, it will check consecutive ones
				if (matrix.getElement(i).getNode(j).getElement().equals(colour)){
					// check if the three checkers that follow will be in the same colour, going towards the right
						for(int check =1 ; check <= 3; check++) {
							if( j + check <= WIDTH-1 && matrix.getElement(i).getNode(j + check).getElement().equals(colour))
								// if they are the same colour, it will add to count
								count++;
							// if count is equal to three, it means there were four consecutive checkers which means they won
								if(count == 3) {
									return true;
								} 
							}
						count = 0;
						// check if the three checks that follow will be in the same colour, going towards the left
						for(int check = 1; check <= 3 ; check++) {
							if( j- check >= 0 && matrix.getElement(i).getNode(j - check).getElement().equals(colour)){	
								// for every checker of the same colour it adds one
								count++;
								
								// if there are three after the original one, they won
								if(count == 3) {
									return true;
								}
							}
						}
						count = 0;
				}		
			}
			}
		// if nothing, return false
		return false; 
		}
	
	private boolean checkVertical(String colour) {
	int count = 0;
		
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				// if there is an element that matches the colour of the input
				if (matrix.getElement(i).getNode(j).getElement().equals(colour)){
					// searches the next three checkers to see if it is the same colour
					for(int check = 1; check <= 3; check++) {
						// checks vertical down the column to see if there are three of the same colour
						if( i + check  <= HEIGHT-1 && matrix.getElement(i + check).getNode(j).getElement().equals(colour)){
							count++;
						}
						// if there are, they won
					} if(count ==3) {
						return true;
					}
					count = 0;
					// checks vertical up the column to see if there are three of the same colour
					for(int check = 1; check <= 3 ; check++) {
						if( i- check >= 0 && matrix.getElement(i - check).getNode(j).getElement().equals(colour)){
							count++;
						}
						// if there are, they won
					} if(count ==3) {
						return true;
					}
					count = 0;
				}		
				}
			}
		// if nothing, return false
		return false; 
		}

	/**
	 * check if there are 4 consecutive checkers diagonal in the upward direction 
	 * @param colour
	 * @return boolean 		true if there are 
	 */
	private boolean checkDiagonalUp(String colour) {
		int count = 0;
		
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				// if there is an element that matches the input colour, it checks the next three
				if (matrix.getElement(i).getNode(j).getElement().equals(colour)){
					for(int check = 1; check <= 3; check++) {
						// moves up and right across the board checking
						if(i - check >= 0 && j + check <= WIDTH-1 && matrix.getElement(i - check).getNode(j + check).getElement().equals(colour)){
							count++;
						}
					// if there are 3 consecutive ones that follow, they've won
					} if(count ==3) {
						
						return true;
					}
				}
				count = 0;
			}
		}
		return false; 
	}

	/**
	 * check if there are 4 consecutive checkers diagonal in the downward direction 
	 * @param colour
	 * @return boolean 		true if there are four consecutive ones
	 */
	private boolean checkDiagonalDown(String colour) {
		int count = 0;
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				//if there is an element that matches the input colour, it checks the next three
				if (matrix.getElement(i).getNode(j).getElement().equals(colour)){
					for(int check = 1; check <= 3; check++) {		
						// moves down and right across the board checking
						if(i + check <= HEIGHT-1 && j + check <= WIDTH-1 && matrix.getElement(i + check).getNode(j + check).getElement().equals(colour)){			
							count++;
						}
						// if there are 3 consecutive ones that follow, they've won
					} if(count ==3) {
						return true;
					}
				}
				count = 0;
			}
		}
		return false; 
	}
	
	/**
	 * Takes a row and col input and a value 
	 * traverse to the row and col to update the value
	 * @param row		the row number
	 * @param col		the column number
	 * @param newValue		the element they wish to update to 
	 */
	private void setElement(int row, int col, String newValue) {
		// finds the element we are changing and update it to the new value 
		matrix.getElement(row).getNode(col).setElement(newValue);
		// if GUI active, we update the board
		if (gui!= null) {
			gui.updateBoard(row, col, newValue);
		}
	}
	
	/**
	 * takes in two int parameters of the row and column and return the element stored in that slot
	 * @param row
	 * @param col
	 * @return		String of the element in that row and col
	 */
	public String getElement(int row, int col) {
		// if the row or column is not within the matrix it will throw a new exception
		if (row >= HEIGHT || col >= WIDTH || row < 0 || col < 0) throw new GameException ("not within the matrix");
		
		// return the element at that row and column 
		return matrix.getElement(row).getNode(col).getElement();	
	}
	
	/**
	 * Take in a column input and a colour choice 
	 * drop the checker into the board
	 * @param col		column the user wish to drop into
	 * @param colour		the colour of the checker
	 */
	public void dropChecker(int col, String colour) {
		
		// if someone has won, it will not run
		if (isGameActive == false) {
			throw new GameException ("Someone already won!");
		}
		// if it is not within the index, it will throw an exception
		if (col >= WIDTH) {
			throw new GameException ("Not within the game board!");
		}
		
		
		// goes up the column 
		for (int i = HEIGHT-1; i >= 0; i--) {
			// the first slot that is empty, we will set the element to the colour indicated 
			if (i>=0 && matrix.getElement(i).getNode(col).getElement().equals("empty")) {
				setElement(i, col, colour);
				checkWin(colour);

				return;
				
			}
			// if the column is full, we will throw a new game exception
			if (i == 0 && !matrix.getElement(i).getNode(col).getElement().equals("empty")) {
				throw new GameException ("column is full");
			}	
		} 
		// this checks if the game has been won


	}
	

}
