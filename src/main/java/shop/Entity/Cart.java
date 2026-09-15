package shop.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "カートIDは必須です")
    public String cartId;

    @NotNull(message = "商品は必須です")
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;


    @NotNull(message = "ユーザーは必須です")
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @Max(value=99,message="99個までしか登録できません")
    @Min(value = 0, message = "数量は0以上で入力してください")
    public Integer cart_quantity;

    public Cart() {
    }

    public Cart(String cartId,Integer cart_quantity){
        this.cartId=cartId;
        this.cart_quantity=cart_quantity;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }


    public int getCartQuantity() { return cart_quantity; }
    public void setCartQuantity(int cartQuantity) { this.cart_quantity = cartQuantity; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
