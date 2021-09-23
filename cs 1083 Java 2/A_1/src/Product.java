/**
 * The Product class stored in Stock
 * @author Yulong Wang
 * @date 2021/09/15
 */
public class Product{
	/**
	 * The initial id number, used to generate id for new products.
	 */
	private static int totalId = 10001;
	/**
	 * The id of product
	 */
	private final int id;
	/**
	 * The name of product
	 */
	private String name;
	/**
	 * The number of available stock.
	 */
	private int numStock;
	/**
	 *	The number of ordered number of product.
	 */
	private int numOrdered;
	/**
	 * The price of the product, round to 2 decimals.
	 */
	private double price;

	/**
	 * @param name The name of the product
	 * @param price The price of the product
	 * @param numStock The number of the product in stock.
	 */
	public Product(String name, double price, int numStock) throws IllegalArgumentException{
		if(price < 0 || numStock < 0){
			throw new IllegalArgumentException();
		}
		this.id = totalId++;
		this.name = name;
		this.numStock = numStock;
		this.numOrdered = 0;
		this.price = Math.round(price * 100.0) / 100.0;
	}

	/**
	 * Receive the order and update numOrdered and numStock.
	 * @return the number of stock after order completed.
	 */
	public int orderReceived(){
		this.numStock += this.numOrdered;
		this.numOrdered = 0;
		return this.numStock;
	}

	/**
	 * Get the total value of the product.
	 * @return double The total value of the product.
	 */
	public double getTotalValue(){
		return Math.round((this.numStock * this.price) * 100.0) / 100.0;
	}

	/**
	 * Sell ONE product.
	 * @return {@link Boolean} If sell succeed.
	 */
	public Boolean sellProduct(){
		if(this.numStock > 0){
			this.numStock -= 1;
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Get the id of the product.
	 * @return int Id of the product.
	 */
	public int getId(){
		return this.id;
	}

	/**
	 * Get the number of product currently in stock.
	 * @return int Number of stock.
	 */
	public int getNumStock(){
		return this.numStock;
	}

	/**
	 * Get the name of the product.
	 * @return String name of product.
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * Get the number of ordered product.
	 * @return int Number of product ordered.
	 */
	public int getNumOrdered(){
		return this.numOrdered;
	}

	/**
	 * Get the price of the product.
	 * @return double price.
	 */
	public double getPrice(){
		return this.price;
	}

	/**
	 * Set the number of ordered products.
	 * @param numOrdered The number ordered.
	 * @return Boolean If change applied.
	 */
	public Boolean setNumOrdered(int numOrdered){
		if(numOrdered < 1){
			return false;
		}
		this.numOrdered = numOrdered;
		return true;
	}

	/**
	 * Change the price of the product.
	 * @param price
	 * @return Boolean If changed applied.
	 */
	public Boolean setPrice(double price){
		if(price < 0){
			return false;
		}
		this.price = Math.round(price * 100.0) / 100.0;
		return true;
	}

	/**
	 * print summary of the product to the terminal.
	 */
	public void summary(){
		System.out.printf("%-20s(id: %s)     qty: %-5s   %-5s ordered   $ %.2f \n",
				this.name,
				this.id,
				this.numStock,
				this.numOrdered,
				this.price
		);
	}

}