import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cart {

    private String itemName;      
    private double totalPrice;  
    private int capacity;
    private List<Map> itemList=new ArrayList<>(); 
    Scanner sc = new Scanner(System.in);
    
    
	public List<Map> getItemList() {
		return itemList;
	}

	public void setItemList(List<Map> itemList) {
		this.itemList = itemList;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void addItems(Cart cart,String itemName, double itemPrice, int quantity) {
		List<Map> itemList= cart.getItemList();
		if(itemList.isEmpty()){
			itemList=new ArrayList<>();
		}
		Map<String, Object> map=new HashMap<>();
		map.put("itemName", itemName);
		map.put("itemPrice", itemPrice);
		map.put("quantity", quantity);
		itemList.add(map);
		cart.setItemList(itemList);
	}

	public void removeItem(Cart cart, String itemName) {
		List<Map> itemList= cart.getItemList();
		int index=-1;
		for(Map map:itemList){
			index++;
			if(map.get("itemName").equals(itemName)){
				break;
			};
		}
		cart.getItemList().remove(index);
	}

	public void updateItem(Cart cart, String itemName, int quantity) {
		List<Map> itemList= cart.getItemList();
		int choice;
		for(Map map:itemList){
			if(map.get("itemName").equals(itemName)){
				System.out.println("Choose\n"+"1.Want to increse quantity\n "+"2.Want to decrease quantity\n");
				choice =sc.nextInt();
				int quant=(int) map.get("quantity");
				if(choice==1)
				{
					map.put("quantity", quant+quantity);
				}
				else if(choice==2)
				{
					map.put("quantity", quant-quantity);
				}
				break;
			}
			else
			{
				System.out.println("Item name not found");
			}
		}
	}

	public void billPrint(Cart cart) {
		int totalAmount=0;
		List<Map> itemList=cart.getItemList();
		for(Map map:itemList){
			totalAmount+=(double) map.get("itemPrice");
		}
		System.out.println("totalAmount= "+totalAmount);
	}

	public void displayCartItems(Cart cart) {
		int i=0;
		List<Map> itemList= cart.getItemList();
		for(Map map:itemList){
			System.out.println("Item "+(i+1)+"---------");
			System.out.println("Item Name: "+map.get("itemName")+"\nQuantity: "+map.get("quantity")+"\nItem price: "+map.get("itemPrice"));
			i++;
		}
	}
	
}
