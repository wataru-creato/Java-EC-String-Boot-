package shop.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public class OrderRequest {

    private String orderId;
    private String orderState;

    @NotNull(message = "注文日は必須です")
    private LocalDate orderDay;

    @Positive(message = "価格は正の数で入力してください")
    private int purchasePrice;

    @Positive(message = "数量は正の数で入力してください")
    private int quantity;

    @NotNull(message = "商品は必須です")
    private Long productId;

    @NotNull(message = "ユーザーは必須です")
    private Long userId;

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getOrderState() { return orderState; }
    public void setOrderState(String orderState) { this.orderState = orderState; }

    public LocalDate getOrderDay() { return orderDay; }
    public void setOrderDay(LocalDate orderDay) { this.orderDay = orderDay; }

    public int getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(int purchasePrice) { this.purchasePrice = purchasePrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}