package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private  CartService cartService;

    @GetMapping
    public List<Cart> getALLCarts(){
        return cartService.getALLCart();
    }

    @PostMapping
    public Cart createALLCarts(@Valid @RequestBody Cart cart){
        return cartService.createAllCart(cart);
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
