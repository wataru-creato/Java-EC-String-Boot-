package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public List<Product> getALLProduct(){

        return productRepository.findAll();
    }

    public Product createAllProduct(Product product){

        return productRepository.save(product);
    }

    public Product updateAllProduct(Product product){
        return productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
