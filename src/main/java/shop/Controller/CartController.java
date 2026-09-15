package shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;
import shop.Entity.Cart;
import shop.Entity.Product;
import shop.Entity.User;
import shop.Repositry.CartRepository;
import shop.Repositry.ProductRepository;
import shop.Repositry.UserRepository;
import shop.Request.CartRequest;
import shop.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Cart> getALLCarts(){
        return cartService.getALLCart();
    }

    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody CartRequest request) {
        // 1. ProductをDBから探す
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("商品が見つかりません"));

        // 2. UserをDBから探す
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("ユーザーが見つかりません"));


        Cart cart = new Cart();
        cart.setCartId(request.getCartId());
        cart.setCartQuantity(request.getCartQuantity());
        cart.setProduct(product);
        cart.setUser(user);

        // 4. 保存
        cartRepository.save(cart);

        return ResponseEntity.ok("カートに追加しました！");
    }


    @PutMapping("/{id}")
    public  Cart updateALLCarts(@PathVariable Long id,@Valid @RequestBody Cart cart){
        cart.id=id;
        return cartService.updateAllCart(cart);
    }

    @DeleteMapping("/{id}")
    public  void deleteCarts(@PathVariable Long id){
        cartService.deleteCart(id);
    }


}
