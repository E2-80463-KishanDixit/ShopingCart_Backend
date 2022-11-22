package shopingCartBackendProject;

import java.util.Scanner;

public class CartMain {
	
	static Product [] allProducts = new Product[] {
            new Product(1,"apple",26),
            new Product(2,"guava",36),
            new Product(3,"mango",16),
            new Product(4,"strawberry",29),
            new Product(5,"banana",56),
            new Product(6,"pineapple",20)
	};

	static Product chooseProduct() {
		Scanner scn = new Scanner(System.in);
		
		// Display all the list
		String productList ="";
		System.out.println("All Available Products :");
		
		for(Product product : allProducts) {
			productList += product.getDisplayName();
		}
		
		System.out.println(productList);
		System.out.println("---------------------------------");
		
		String choice;
		choice = scn.nextLine();
		
		for(int i=0;i<allProducts.length;i++) {
			if(allProducts[i].getShortName().equals(choice)) {
				return allProducts[i];
			}
		}
		System.out.println("Product Not Found");
		return null;
	}
	
	static boolean checkOut(Cart cart) {
		Scanner scn = new Scanner(System.in);
		if(cart.isEmpty()) {
			System.out.println("No Item has been purchased");
			return false;
		}
		
		int total = cart.getTotal();
		System.out.println("Pay in Cash. Please!");
		
		int paid = scn.nextInt();
		if(paid>=total) {
			System.out.println("Change  "+ (total - paid));
			System.out.println("Thank You For Shoping!");
			return true;
		}else {
			System.out.println("Not Enough Cash! Sorry!!!!!!!!!!!!");
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		char action;
		Cart cart = new Cart();
		
		while(true) {
			System.out.println("Select an Action :  (a)dd Item, (r)emove Item  (v)iew cart, (c)heckout ");
			action = scn.next().charAt(0);
			
			if(action=='a') {
				// Todo:  view all products + choose product + add to the cart
				Product product = chooseProduct();
				if(product!=null) {
					System.out.println("Added to the Cart  "+ product.getDisplayName());
					cart.addProduct(product);
				}
			}else if(action =='r') {
				Product product = chooseProduct();
				if(product!=null) {
					System.out.println("Removed from the Cart  "+ product.getDisplayName());
					cart.removeProduct(product);
				}
			}else if(action=='v') {
				// View Cart
				System.out.println("----------------------------------------------------");
				System.out.println(cart.viewCart());
				System.out.println("----------------------------------------------------");
				
			}else if(action == 'c') {
				// Checkout 
				cart.viewCart();
				if(checkOut(cart)) {
					break;
				}
			}
		}
	}
}

