package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getALLCart(){
        return cartRepository.findAll();
    }

    public Cart createAllCart(Cart cart){
        return cartRepository.save(cart);
    }

    public Cart updateAllCart(Cart cart){
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id){
        cartRepository.deleteById(id);
    }

}
