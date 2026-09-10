package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

import jakarta.validation.Valid;

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
