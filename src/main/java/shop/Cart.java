package shop;

public class Cart {
    public String cartId;
    public String Product_id;
    public int cart_quantity;

    public Cart(String cartId,String Product_id,int cart_quantity){
        this.cartId=cartId;
        this.Product_id=Product_id;
        this.cart_quantity=cart_quantity;
    }

    public String showCartInfo(){
        return "カートID："+cartId+",商品ID："+Product_id+",注文数："+cart_quantity;
    }
}
