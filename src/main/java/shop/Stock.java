package shop;

public class Stock {
    public String Product_id;
    public int Stock_quantity;

    public Stock(String Product_id,int Stock_quantity){
        this.Product_id=Product_id;
        this.Stock_quantity=Stock_quantity;
    }

    public String showStockQuantity(){
        return "商品ID:"+Product_id+"/在庫数："+Stock_quantity;
    }
}
