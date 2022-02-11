/**
Defines a class that represents a list of integers
*/
public class IntList {

	/**
	First node in the list
	*/
	private IntNode front;

	/**
	 * Constructs a list.  Initially the list is empty.
	 */
	public IntList() {
		front = null;
	}

	/**
	 * Adds given integer to front of list.
	 *
	 * @param val integer to add to the front of the list
	 */
	public void addToFront(int val) {
		front = new IntNode(val, front);
	}

	/**
	 * Removes the first node from the list.
	 * If the list is empty, does nothing.
	 */
	public void removeFirst() {
		if (front != null) {
			front = front.next;
		}
	}

	/**
	 * Prints the list elements from first to last.
	 */
	public void print() {
		System.out.println("--------------------");
		System.out.print("List elements: ");
		IntNode temp = front;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println("\n-----------------------\n");
	}

	/**
	 * return the length of the linked list
	 * @return int the length of the linked list
	 */
	public int length(){
		IntNode temp = front;
		int length = 0;
		while(temp!=null){
			temp = temp.next;
			length++;
		}
		return length;
	}

	/**
	 * add a node to the end of the list
	 * @param val the val to be added
	 */
	public void addToEnd(int val){
		if(front!=null) {
			IntNode temp = front;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new IntNode(val, null);
		}else{
			front = new IntNode(val, null);
		}
	}

	/**
	 * remove the last element in the linked list
	 */
	public void removeLast(){
		if(front!=null){
			if(front.next==null){
				front = null;
				return;
			}
			IntNode temp = front;
			IntNode pre = temp;
			while(temp.next!=null){
				pre = temp;
				temp = temp.next;
			}
			pre.next = null;
		}
	}

	/**
	 * replace all oldVal with newVal in the linked list
	 * @param oldVal old int value
	 * @param newVal new int value
	 */
	public void replace(int oldVal, int newVal){
		IntNode temp = front;
		while(temp!=null){
			if(temp.val == oldVal){
				temp.val = newVal;
			}
			temp = temp.next;
		}
	}

	/**
	 * print the link recursively
	 */
	public void printRec(){
		recHelper(front);
	}

	/**
	 * helper function
	 * @param temp
	 */
	private void recHelper(IntNode temp){
		if(temp==null){
			return;
		}
		System.out.println(temp.val);
		recHelper(temp.next);
	}

	/**
	 * print linked list backwards recursivly
	 */
	public void printRecBackwards(){
		recBackwardsHelper(front);
	}

	/**
	 * helper function
	 * @param temp
	 */
	private void recBackwardsHelper(IntNode temp){
		if(temp==null){
			return;
		}
		recBackwardsHelper(temp.next);
		System.out.println(temp.val);
	}

	/**
	An inner class that represents a node in the integer list.
	The public variables are accessed by the IntList class.
	*/
	private class IntNode {
		
		/**
		Value stored in node.
		*/
		public int val; 
		
		/**
		Link to next node in list.
		*/
		public IntNode next; 
		
		/**
		Constructor; sets up the node given a value and IntNode reference
		@param val the value to store in the node
		@param next the link to the next node in the list
		*/
		public IntNode(int val, IntNode next) {
			this.val = val;
			this.next = next;
		}
	}
}

