package shop;

public class Order {
    public String orderId;
    public String user_id;
    public java.time.YearMonth  order_day;
    public int purchasePrice;
    public int quantity;
    public String orderState;

    public Order(String orderId,String user_id,java.time.YearMonth  order_day,int purchasePrice,int quantity,String orderState){
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

