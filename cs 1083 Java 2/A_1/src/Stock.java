/**
 * A Stock class that stores multiple Products.
 * @author Yulong Wang
 * @date 2021/09/15
 */
public class Stock{
	/**
	 The max number of products can be stored in the stock
	 */
	private int maxNumOfProducts;
	/**
	 Current number of product in the stock
	 */
	private int numOfProducts;
	/**
	 The list stores the product objects.
	 */
	private Product[] products;

	/**
	 * init the Stock
	 * @param maxNumOfProducts the max number of products this stock can store
	 */
	public Stock(int maxNumOfProducts) throws IllegalArgumentException{
		if(maxNumOfProducts < 0){
			throw new IllegalArgumentException();
		}
		this.maxNumOfProducts = maxNumOfProducts;
		this.numOfProducts = 0;
		this.products = new Product[maxNumOfProducts];
	}

	/**
	 * find a given product in the stock.
	 * @param product the target product.
	 * @return The index of the given product in the products array. If product not found, return -1.
	 */
	private int getProductIndex(Product product){
		for(int i = 0; i < this.maxNumOfProducts; i++){
			if(this.products[i] != null && this.products[i].getId() == product.getId()){
				return i;
			}
		}
		return -1;
	}

	/**
	 * Add a product to stock.
	 * @param product The product need to be added.
	 * @return {@link Boolean} Where the operation is successful.
	 */
	public Boolean addProduct(Product product){
		if (this.numOfProducts > this.maxNumOfProducts){
			return false;
		}
		for(int i = 0; i < this.maxNumOfProducts; i++){
			if(this.products[i] == null){
				this.products[i] = product;
				return true;
			}
		}
		return false;
	}

	/**
	 * Sell a product in the stock
	 * @param product The product need to be sold.
	 * @return {@link Boolean} If selling succeed.
	 */
	public Boolean sellProduct(Product product){
		return product.sellProduct();
	}

	/**
	 * Remove a product from the stock.
	 * @param product The product need to be removed.
	 * @return {@link Boolean} If operation succeed.
	 */
	public Boolean removeProduct(Product product){
		int index = this.getProductIndex(product);
		if(index > -1){
			this.products[index] = null;
			return true;
		}
		return false;
	}

	/**
	 * Check if a product is low in stock (stock < 5).
	 * @param product The product need to be checked.
	 * @return {@link Boolean} If the product need to be refilled.
	 */
	public Boolean fillProductStock(Product product){
		int index = this.getProductIndex(product);
		if(index > 0 && this.products[index].getNumStock() < 5){
			product.setNumOrdered(10);
			return true;
		}
		return false;
	}

	/**
	 * Get the total value of all product in the stock.
	 * @return double The total value.
	 */
	public String getTotalValue(){
		double totalValue = 0;
		for(int i = 0; i < this.maxNumOfProducts; i++){
			if(this.products[i] != null){
				totalValue += this.products[i].getTotalValue();
			}
		}
		return "$ " + Math.round(totalValue * 100.0) / 100.0;
	}

	/**
	 * print summary of all products to the terminal.
	 */
	public void summary(){
		for(int i=0; i<this.maxNumOfProducts; i++) {
			Product product = this.products[i];
			if (product != null) {
				product.summary();
			}
		}
	}


}