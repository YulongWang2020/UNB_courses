import java.io.File;
import java.util.Scanner;

public class TestWishList{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		WishList bridesList = new WishList(sc);
		System.out.println("List 1: \n" + bridesList);

		System.out.println("Item" +
				(bridesList.addItem(new Item("Rice Cooker & Steamer", 11881701910L, 2))?"":" not") +
				" added to List 1: \n" + bridesList);

		WishList groomsList = new WishList(sc);
		System.out.println("List 2: \n" + groomsList);

		System.out.println("There are " + bridesList.findUnique(groomsList)
				+ " items found in one wish list but not the other");
		System.out.println("Merged wish lists:" );
		System.out.println(bridesList.merge(groomsList));
	}
}
