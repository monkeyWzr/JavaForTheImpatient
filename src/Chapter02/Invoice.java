package Chapter02;

import java.util.ArrayList;

public class Invoice {
    
    private static class Item {
        String description;
        int quantity;
        double unitPrice;
        
        double price() {
            return quantity * unitPrice;
        }
        
        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }
    }

    private ArrayList<Item> items = new ArrayList<>();
    
    public Invoice() {
        // TODO Auto-generated constructor stub
    }
    
//    public void addItem(String description, int quantity, double unitPrice) {
//        Item newItem = new Item();
//        newItem.description = description;
//        newItem.quantity = quantity;
//        newItem.unitPrice = unitPrice;
//        items.add(newItem);
//    }
    
    public void add(Item item) {
        items.add(item);
    }
}
