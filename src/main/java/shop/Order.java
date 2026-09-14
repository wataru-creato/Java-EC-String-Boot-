package shop;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "注文IDは必須です")
    public String orderId;

    @NotNull(message = "ユーザーは必須です")
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

//    @NotBlank(message = "ユーザIDは必須です")
//    public String user_id;

    @NotNull(message="注文日は必須です")
    public LocalDate  order_day;


    @NotNull(message = "商品は必須です")
    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;

    @Positive(message = "価格は正の数で入力してください")
    public int purchasePrice;

    @Max(value=9999,message="9999個までしか登録できません")
    public int quantity;

    @NotBlank(message="ステータスは必須です")
    public String orderState;

    public Order(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getOrderDay() {
        return order_day;
    }

    public void setOrderDay(LocalDate order_day) {
        this.order_day = order_day;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }



    public Order(String orderId,String user_id,LocalDate  order_day,int purchasePrice,int quantity,String orderState){
        this.orderId=orderId;
        this.order_day=order_day;
        this.purchasePrice=purchasePrice;
        this.quantity=quantity;
        this.orderState=orderState;

    }

    public int calculateTotalAmount() {
        return this.purchasePrice * this.quantity;
    }


}

