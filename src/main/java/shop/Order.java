package shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

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
    @NotBlank(message = "ユーザIDは必須です")
    public String user_id;

    @NotNull(message="注文日は必須です")
    public LocalDate  order_day;

    @Positive(message = "価格は正の数で入力してください")
    public int purchasePrice;

    @Max(value=9999,message="9999個までしか登録できません")
    public int quantity;

    @NotBlank(message="ステータスは必須です")
    public String orderState;

    public Order(){

    }

    public Order(String orderId,String user_id,LocalDate  order_day,int purchasePrice,int quantity,String orderState){
        this.orderId=orderId;
        this.user_id=user_id;
        this.order_day=order_day;
        this.purchasePrice=purchasePrice;
        this.quantity=quantity;
        this.orderState=orderState;

    }

    public String orderShowDetail(){
        return "注文ID: " + orderId + ", ユーザーID: " + user_id + ", 注文日: " + order_day + ", 単価: " + purchasePrice + "円" + ", 数量: " + quantity + ", ステータス: " + orderState;
    }

    public int calculateTotalAmount() {
        return this.purchasePrice * this.quantity;
    }

}

