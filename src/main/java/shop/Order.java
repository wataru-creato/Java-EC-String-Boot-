package shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String orderId;
    public String user_id;
    public LocalDate  order_day;
    public int purchasePrice;
    public int quantity;
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

