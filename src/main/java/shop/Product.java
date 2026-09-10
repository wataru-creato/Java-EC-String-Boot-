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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "商品IDは必須です")
    public String Product_id;

    @NotBlank(message="商品名は必須です")
    public String Product_name;

    @Positive(message = "価格は正の数で入力してください")
    public int price;

    public String Product_description;
    public String Category;

    public Product() {
    }

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



