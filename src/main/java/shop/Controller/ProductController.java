package shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;
import shop.Entity.Product;
import shop.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getALLProduct();

    }

    @PostMapping
    public Product createProducts(@Valid @RequestBody Product product){

        return productService.createAllProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProducts(@PathVariable Long id,@Valid @RequestBody Product product){
        product.id = id;
        return productService.updateAllProduct(product);
    }

    @DeleteMapping("/{id}")
    public void  deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}
