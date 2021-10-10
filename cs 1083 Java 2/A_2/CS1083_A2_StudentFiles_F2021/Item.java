/**
 Represents an item in a customer's wish list.
*/
public class Item {
	/**
	 The descriptive name of the item.
	*/
	private final String NAME;
	
	/**
	 The Stock Keeping Unit (SKU) code for the item; this is the number 
	 that appears below the barcode on the item's tag.
	*/
	private final long SKU;
	
	/**
	 The priority that the customer has assigned to this wish list item;
	 1 = high, 2 = medium and 3 = low.
	*/
	private int priority;

	/**
	 Constructs an Item with the given name and SKU and a default priority
	 of 2 (medium).
	 @param nameIn The name of the item.
	 @param skuIn The item SKU.
	*/
	public Item (String nameIn, long skuIn) {
		NAME = nameIn;
		SKU = skuIn;
		priority = 2;
	}
	
	/**
	 Constructs an Item with the given name, SKU and priority.
	 @param nameIn The name of the item.
	 @param skuIn The item SKU.
	 @param priorityIn The priority of the item.
	*/
	public Item (String nameIn, long skuIn, int priorityIn) {
		NAME = nameIn;
		SKU = skuIn;
		priority = priorityIn;
	}

	/**
	 Retrieves the item's SKU.
	 @return The item SKU.
	*/
	public long getSKU() {
		return SKU;
	}

	/**
	 Retrieves the item's name.
	 @return The item name.
	*/
	public String getName() {
		return NAME;
	}

	/**
	 Retrieve's the priority level that the customer has selected 
	 for this item.
	 @return The item's priority.
	*/
	public int getPriority() {
		return priority; 
	}

	/**
	 Changes the item's priority to the specified value, provided 
	 that it is within the acceptable range.
	 @param priorityIn The new priority of the item.
	 @return If the priority was changed.
	*/
	public boolean setPriority(int priorityIn) {
		boolean success = false;
		if (priorityIn >= 1 && priorityIn <=3) {
			priority = priorityIn;
			success = true;
		}
		return success;
	}

	/**
	 Calculates the difference between this item's SKU and that 
	 of the other item passed in as a parameter.
	 @param other The other item.
	 @return The difference the SKU's.
	*/
	public long getSkuDiff (Item other) {
		return SKU - other.SKU;
	}
}

