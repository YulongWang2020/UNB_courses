/**
 * @author Yulong Wang
 * @date 2021/09/15
 */
public class StockAndProductDriver{
	public static void main(String[] args){
// 		1. Create some products.
		System.out.println("1. Create some products.");
		Product p1 = new Product("iphone13", 699.00, 10);
		System.out.print("p1: ");
		p1.summary();
		Product p2 = new Product("ipad", 299, 3);
		System.out.print("p2: ");
		p2.summary();
		Product p3 = new Product("mac book pro", 1699.991, 6);
		System.out.print("p3: ");
		p3.summary();
		Product p4 = new Product("apple watch", 399.99, 8);
		System.out.print("p4: ");
		p4.summary();
		Product p5 = new Product("air pods", 199.123, 20);
		System.out.print("p5: ");
		p5.summary();
//		Try meaningless init
		try{
			System.out.print("Create product with negative price: ");
			Product wrongPrice = new Product("apple ball", -10, 10);
		}catch (IllegalArgumentException e){
			System.out.println(e);
		}

		try{
			System.out.print("Create product with negative stock: ");
			Product wrongStock = new Product("apple ball", 10, -10);
		}catch (IllegalArgumentException e){
			System.out.println(e);
		}
		System.out.println("========================================================");
// 		2. Create a Stock and add Product to the stock.
		System.out.println("2. Create a Stock and add Product to the stock.");
		Stock stock = new Stock(4);
		System.out.println("-------------------------BEFORE------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> create a Stock with 4 max number of products");
		System.out.println("-> adding p1: " + stock.addProduct(p1));
		System.out.println("-> adding p2: " + stock.addProduct(p2));
		System.out.println("-> adding p3: " + stock.addProduct(p3));
		System.out.println("-> adding p4: " + stock.addProduct(p4));
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("========================================================");
//		3. Add more than max number of products allowed.
		System.out.println("3. Add more than max number of products allowed.");
		System.out.println("-------------------------BEFORE------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> adding p5: " + stock.addProduct(p5));
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("========================================================");
//		4. Remove a product.
		System.out.println("4. Remove a product.");
		System.out.println("-------------------------BEFORE------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> remove p1: " + stock.removeProduct(p1));
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("========================================================");
//		5. Add another product.
		System.out.println("5. Add another product.");
		System.out.println("-------------------------BEFORE------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> add p5: " + stock.addProduct(p5));
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("========================================================");
//		6. Remove a product does not exist;
		System.out.println("6. Remove a product does not exist.");
		System.out.println("-------------------------BEFORE------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> remove p1: " + stock.removeProduct(p1));
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("========================================================");
//		7. Sell a product.
		System.out.println("7. Sell a product.");
		System.out.println("-------------------------BEFORE------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> sell p2: " + stock.sellProduct(p2));
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("========================================================");
//		8. Sell a product that is no more available.
		System.out.println("8. Sell a product that is no more available.");
		System.out.println("-------------------------BEFORE------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
//		Empty the stock.
		System.out.println("-> empty p5 stock");
		for(int i = p5.getNumStock(); i > 0; i--){
			stock.sellProduct(p5);
		}
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> sell p5: " + stock.sellProduct(p5));
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("========================================================");
//		9. Order new product running low.
		System.out.println("9. Order new product running low.");
		System.out.println("-------------------------BEFORE------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> order p2: " + stock.fillProductStock(p2));
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("-> receive order of p2: " + p2.orderReceived());
		System.out.println("-------------------------AFTER------------------------ ");
		stock.summary();
		System.out.println("------------------------------------------------------ ");
		System.out.println("========================================================");
//		10. Display the total value of all products.
		System.out.println("10. Display the total value of all products.");
		System.out.println(stock.getTotalValue());
	}
}