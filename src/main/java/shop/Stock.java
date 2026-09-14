package shop;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Max(value=9999,message="9999個までしか登録できません")
    @Min(value = 0, message = "数量は0以上で入力してください")
    public int stock_quantity;

    @NotNull(message = "商品IDは必須です")
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;

    public Stock() {
    }

    public Stock(int stock_quantity){

        this.stock_quantity=stock_quantity;
    }

    public int getStockQuantity() { return stock_quantity; }
    public void setStockQuantity(int stock_quantity){this.stock_quantity=stock_quantity;}
    public void setProduct(Product product) { this.product = product; }
}
