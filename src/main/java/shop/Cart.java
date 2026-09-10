package shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;


@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "カートIDは必須です")
    public String cartId;

    @NotBlank(message = "商品IDは必須です")
    public String Product_id;

    @Max(value=99,message="99個までしか登録できません")
    @Min(value = 0, message = "数量は0以上で入力してください")
    public int cart_quantity;

    public Cart() {
    }

    public Cart(String cartId,String Product_id,int cart_quantity){
        this.cartId=cartId;
        this.Product_id=Product_id;
        this.cart_quantity=cart_quantity;
    }

    public String showCartInfo(){
        return "カートID："+cartId+",商品ID："+Product_id+",注文数："+cart_quantity;
    }
}
