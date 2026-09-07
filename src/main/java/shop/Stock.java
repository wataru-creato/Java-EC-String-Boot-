package shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String Product_id;
    public int Stock_quantity;

    public Stock() {
    }

    public Stock(String Product_id,int Stock_quantity){
        this.Product_id=Product_id;
        this.Stock_quantity=Stock_quantity;
    }

    public String showStockQuantity(){
        return "商品ID:"+Product_id+"/在庫数："+Stock_quantity;
    }
}
