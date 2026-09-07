package shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class Controller {

    @GetMapping("/recipes")
    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();
        products.add(new Product("A001", "味噌汁", 100, "", "副菜"));

//       for(Product p:products) {
//            System.out.println(p.showInfo());
//        }
        return products;
    }

    @GetMapping("/recipes/stock")
    public List<Stock> getStocks(){
        List<Stock> stocks=new ArrayList<>();
        stocks.add(new Stock("A001",10));
        return stocks;
    }

    @GetMapping("/recipes/user")
    public List<User> getUser(){
        List<User> users=new ArrayList<>();
        users.add(new User("0001","admin","gmail.com","1111","東京都","0120"));
        return users;
    }

    @GetMapping("/recipes/cart")
    public List<Cart> getCart(){
        List<Cart> carts=new ArrayList<>();
        carts.add(new Cart("1","A0001",1));
        return carts;
    }
}
