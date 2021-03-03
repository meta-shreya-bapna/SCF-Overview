import java.util .*;

public class Shopping_Cart {

	public static void main(String[] args) {
		String itemName;
		double itemPrice;
		int quantity;
		Scanner sc = new Scanner(System.in);
		Cart cart = new Cart();
		boolean flag = true;
		while (flag == true) {
			int choice;
			System.out.println("\n 1: Add To Cart" 
					+ "\n 2: Remove From Cart "
					+ "\n 3: Update quantity of item from cart"
					+ "\n 4: Print Bill"
					+ "\n 5: Display All Cart Items"
					+ "\n 6: Exit" );
			choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.print("Enter the name of the item: ");
				itemName = sc.next();

				System.out.print("Enter the unit price: ");
				itemPrice = sc.nextDouble();

				System.out.print("Enter the quantity: ");
				quantity = sc.nextInt();

				cart.addItems(cart,itemName, itemPrice, quantity);

				break;

			case 2:
				
				System.out.print("Enter the name of the item: ");
				itemName = sc.next();
				cart.removeItem(cart, itemName);
				break;

			case 3:
				
				System.out.print("Enter the name of the item: ");
				itemName = sc.next();
				System.out.print("Enter the quantity you want to increase or decrease in the initial: ");
				quantity = sc.nextInt();
				cart.updateItem(cart, itemName, quantity);
				break;

			case 4:
				
				cart.billPrint(cart);
				break;
				
			case 5:
				
				cart.displayCartItems(cart);
				break;
			
			case 6:
				
				flag = false;
				break;

			default:
				System.out.println("Invalid input");
			}
		}
		sc.close();
	}
}