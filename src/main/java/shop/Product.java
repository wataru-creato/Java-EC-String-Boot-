package shop;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Product {
    public String Product_id;
    public String Product_name;
    public int price;
    public String Product_description;
    public String Category;

    public Product(String Product_id,String Product_name,int price,String Product_description,String Category){
        this.Product_id=Product_id;
        this.Product_name=Product_name;
        this.price=price;
        this.Product_description=Product_description;
        this.Category=Category;
    }

    public String showInfo(){
        return "商品ID:"+Product_id+"/商品名："+Product_name+"/値段："+price+"/カテゴリ："+Category;
    }
    public String showDescription(){
        return "商品名："+Product_name+"/商品説明："+Product_description;
    }
}



