package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getALLProduct();

    }

    @PostMapping
    public Product createProducts(@RequestBody Product product){

        return productService.createAllProduct(product);
    }

    @PutMapping
    public Product updateProducts(@RequestBody Product product){

        return productService.updateAllProduct(product);
    }

    @DeleteMapping("/{id}")
    public void  deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }










//    @GetMapping("/recipes/stock")
//    public List<Stock> getStocks(){
//        List<Stock> stocks=new ArrayList<>();
//        stocks.add(new Stock("A001",10));
//        return stocks;
//    }
//
//    @GetMapping("/recipes/user")
//    public List<User> getUser(){
//        List<User> users=new ArrayList<>();
//        users.add(new User("0001","admin","gmail.com","1111","東京都","0120"));
//        return users;
//    }
//
//    @GetMapping("/recipes/cart")
//    public List<Cart> getCart(){
//        List<Cart> carts=new ArrayList<>();
//        carts.add(new Cart("1","A0001",1));
//        return carts;
//    }
}
