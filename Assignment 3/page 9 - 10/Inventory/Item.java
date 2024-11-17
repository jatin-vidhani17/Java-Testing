package Inventory;

public class Item {
    static int itemId;
    int id;
    String descrption;
    float price;
    int quantity;
    float total_bill_amount;

    static private void incrementItemId(){
        itemId++;
        
    }

    public Item(String desc, float price, int quantity){
        incrementItemId();
        this.id = itemId;
        this.descrption = desc;
        this.price = price;
        this.quantity = quantity;
    }

    public int getItemId(){
        return this.id;
    }

    public String getItemDescrption(){
        return this.descrption;
    }

    public float getItemPrice(){
        return this.price;
    }

    public void createBill(){
        Bill_Item Bill = new Bill_Item(this.quantity, this.price);
        Bill.calculateAmount();
        this.total_bill_amount = Bill.amount;
    }

    public float getBillAmount(){
        createBill();
        return this.total_bill_amount;
    }
    
    public int getItemQuantity(){
        return this.quantity;

    }

    class Bill_Item{
        int quantity;
        float amount;
        float price;
        
        
        public Bill_Item(int q, float price){
            this.quantity = q;
            this.price = price;
            
            
        }
        
        public void calculateAmount(){
            this.amount = quantity * price;
        }
        

    }


}
