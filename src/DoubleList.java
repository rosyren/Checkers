/**
 * This class creates a Doubly Linked List which gives the game structure for the connect four game 
 * @author Rosy Ren (251080052) CS 1027
 * @param <T> generic type
 */
public class DoubleList<T> {
	/**
	 * declaring the variables within the DoubleList 
	 * DoubleNode of the front of the list 
	 * DoubleNode of the end of the list 
	 * integer count which keeps track of how many nodes are in the Doubly Linked list
	 */
	private DoubleNode<T> front;
	private DoubleNode<T> rear;
	int count;

	/**
	 * constructor that sets all of the instance variables to the default values 
	 * count = 0, there are no nodes within the list 
	 * the front is equal to the back which is null
	 */
	
	public DoubleList() {
		count = 0;
		front = rear = null;
	}
	
	/**
	 * takes in parameter of generic type which represents the element to be added
	 * creates a DoubleNode with this element and add it to the rear of the list 
	 * @param element of generic type
	 */
	
	public void addToRear (T element) {
		
		DoubleNode<T> node = new DoubleNode<T> (element);
		DoubleNode<T> current = new DoubleNode<T> (element);
		
		// this accounts for when the list is empty, so the new node is set as front 
		if (front == null) {
			front = rear = node;
			count ++;
			return;
			
		} 
		
		current = front;
		
		// this traverses the Linked list until it gets to the rear of the list 
		while (current.getNext() != null) {
				current = current.getNext();
			}
		
		// sets the rear to point to the new node 
		current.setNext(node);
		// set the new node to point back to the old rear
		node.setPrevious(current);
		// set the new rear to the node
		rear = node;
		count ++;
	}
	
	/**
	 * takes in an int parameter that indicates the number of nodes to traverse
	 * return the node that the traversal ends on
	 * @param index		which node the user wants to traverse to 
	 * @return DoubleNode<T> of the generic type 
	 */
	public DoubleNode<T> traverseForwards(int index) {
		// if the list is empty, it will return "empty list"
		if (front == null)
			System.out.println("Empty list");
		
		// keeps track of how far along the list the traversal is 
		int number = 0;
		DoubleNode<T> node = front;
		// while the current node is not equal to the node we are supposed to be on, we keep traversing
		while (node.getNext() != null && number != index) {
			node = node.getNext();
			number ++;
		} 
		// if the index of traversal is equal to the index inputed, it will return the node in that spot
		if (number == index) return node;
		return node; 		
	
	}
	/**
	 * takes in an int parameter that indicates the number of nodes to traverse backwards
	 * return the node that the traversal ends on
	 * @param index		how far back the user wants to traverse
	 * @return DoubleNode<T> of the generic type 
	 */
	public DoubleNode<T> traverseBackwards(int index){
		// if the list is empty, it will return "empty list"
		if (front == null) 
			System.out.println("Empty list");
		
		// we start at the rear and move forward
		DoubleNode<T> node = rear;
		// if the current node isn't equal to the node we're supposed to be on, we keep traversing
		for (int i = 0; i < index; i ++) {
			node = node.getPrevious();
		}
		
		// we return the node we're on
		return node;
	}
	/**
	 * takes in an int parameter that indicates the index of the node they wish to return
	 * @param index		 the index of the node the user wish to return 
	 * @return DoubleNode<T> of the generic type 
	 */
	public DoubleNode<T> getNode(int index){
		
		// if the list is empty or the index is out of bounds, it will throw a DoubleList Exception
		if (index < 0 || index >= count) {
			throw new DoubleListException("Not within the list");
		}
		
		DoubleNode<T> node = new DoubleNode<T>();
		// if the index is in the first half of the list, it will traverse forward
		if (index < count/2) {
			node = traverseForwards(index);
		}
		// if the index is in the second half of the list, it will traverse backwards
		if (index >= count/2) {
			node = traverseBackwards(count - index -1);
		}
		
		return node;

	}
	/**
	 * takes in an index and element of the generic type 
	 * find the node to be updated and change it 
	 * @param index		which node in the list do they wish to change
	 * @param elem		the element they wish to change to
	 */
	public void setElement(int index, T elem) {
		
		DoubleNode<T> node = new DoubleNode<T>();
		// traverse to find the node to change
		node = getNode(index);
		// update the element within the node
		node.setElement(elem);
		
	}
	
	/**
	 * takes in an int index parameter which indicates which node's element we wish to return 
	 * @param index		the node we wish to return the element of
	 * @return element of the generic type 
	 */
	public T getElement(int index) {
		return getNode(index).getElement();

	}
	/**
	 * returns a string representing the Doubly Linked List 
	 * @return string representation of the list 
	 */
	public String toString() {
	
		if (count == 0) return "Empty list";
		String result = "";
		
		// iterates through the list and creates a String representation
		DoubleNode<T> current = front;
		while (current.getNext() != null) {
			result += current.getElement().toString() + " ";
			current = current.getNext();
		}
		result += current;
		return result;

		
	
	} 
	


}

