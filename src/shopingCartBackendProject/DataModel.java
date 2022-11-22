package shopingCartBackendProject;

import java.util.HashMap;
import java.util.Map;

class Product{
	int id;
	String name;
	int price;
	
	Product(int id,String name,int price){
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String getDisplayName() {
		return name +"  : Rs  "+ (price)+"\n";
	}
	String getShortName() {
		return name.substring(0,1);
	}
}

class Item{
	Product product;
	int  quantity;
	
	Item(Product product,int quantity){
		this.product = product;
		this.quantity = quantity;
	}
	
	int getItemPrice() {
		return quantity*product.price;
	}
	String getItemInfo() {
		return (quantity)+" Kg. "+" x "+ product.name +"  Rs:  "+ (quantity * product.price)+"\n";
	}
}
class Cart{
	HashMap<Integer,Item> items =  new HashMap<>();
	
	void addProduct(Product product){
		if(!items.containsKey(product.id)) {
			Item newItem = new Item(product,1);
			items.put(product.id, newItem);
		}else {
			items.get(product.id).quantity+=1;
		}
	}
	
	void removeProduct(Product product) {
		if(items.get(product.id).quantity>1) {
			items.get(product.id).quantity--;
		}else {
			items.remove(product.id);
		}
	}
	
	int getTotal() {
		int total =0;
		for(Map.Entry<Integer, Item> itemPair : items.entrySet()) {
			Item item = itemPair.getValue();
			total +=item.getItemPrice();
		}
		return total;
	}
	String viewCart() {
		if(items.isEmpty()) {
			return "Cart is Empty";
		}
		String itemizedList ="";
		for(Map.Entry<Integer, Item> itemPair : items.entrySet()) {
			Item item = itemPair.getValue();
			itemizedList += (item.getItemInfo());
		}
		int cartTotal = getTotal();
		return itemizedList + "\n Total Amount : Rs. " + ( cartTotal)+'\n';
	}
	
	boolean isEmpty() {
		return items.isEmpty();
	}
}
public class DataModel {
}
