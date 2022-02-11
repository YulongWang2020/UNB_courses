import java.util.Scanner;

public class WishList {
	/**
	 The items on the customer's wish list, sorted by sku.
	*/
	private Item[] list;

	/**
	 Constructs a new WishList given a sorted array of Items.
	 @param listIn The list of items.
	*/
	public WishList (Item[] listIn) {
		list = listIn;
	}
	
	/**
	 Constructs a new WishList by reading the number of items and then 
	 the sorted list of item information using a Scanner; input format 
	 consists of a line with the number of items, followed by a line for 
	 each item containing values separated by commas
	 @param scin The Scanner reading input.
	*/
	public WishList (Scanner scin) {
		int count = scin.nextInt();
		scin.nextLine(); //read newline following the first int
		list = new Item[count];
		for(int i=0; i < count; i++){
			String s = scin.nextLine();
			Scanner scline = new Scanner(s);
			scline.useDelimiter(",");
			long sku = scline.nextLong();
			String name = scline.next();
			int priority = scline.nextInt();
			list[i] = new Item(name, sku, priority);
		}
	}

	/**
	 Returns the number of items that appear in only one of the two
	 wish lists (this one and the other one that is passed in as a
	 parameter). 
	 @param other The other wish list.
	 @return The number of items that appear in only one of the two lists.
	*/
	public int findUnique (WishList other){
		//TO DO: Complete this method
	}

	/**
	 Merges this wish list with another one (passed in as a parameter),
	 producing a new sorted wish list.
	 @param other The wish list to be merged with this wish list.
	 @return The merged wish list.
	*/ 
	public WishList merge (WishList other){
		//TO DO: Complete this method
	}

	/**
	Updates the wish list by adding the item passed in as a parameter to 
	the wish list in the correct order if the item is not already in the list. 
	@param newItem The item to be added to this wish list.
	@return If item was added successfully or not.
	*/
	public boolean addItem (Item newItem){
		//TO DO: Complete this method
	}
	
	public String toString(){
		String s = "";
		for(int i=0; i < list.length; i++){
			s += list[i].getSKU() + "\t" + list[i].getName() + "\t" 
				+ list[i].getPriority() + "\n";
		}
		return s;
	}

}
