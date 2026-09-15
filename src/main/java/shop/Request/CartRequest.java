package shop.Request;

public class CartRequest {
    private String cartId;
    private Integer cartQuantity;
    private Long productId;
    private Long userId;

    // ゲッターとセッター
    public String getCartId() { return cartId; }
    public void setCartId(String cartId) { this.cartId = cartId; }
    public Integer getCartQuantity() { return cartQuantity; }
    public void setCartQuantity(Integer cartQuantity) { this.cartQuantity = cartQuantity; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}