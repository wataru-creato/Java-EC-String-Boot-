package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    public StockService stockService;

    @Autowired
    public StockRepository stockRepository;

    @Autowired
    public ProductRepository productRepository;

    @GetMapping
    public List<Stock> getAllStocks(){
        return stockService.getAllStock();
    }

    @PostMapping
    public ResponseEntity<?> createStock(@RequestBody StockRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("商品が見つかりません"));

        Stock stock = new Stock();
        stock.setStockQuantity(request.getStockQuantity());
        stock.setProduct(product);

        // 3. 保存
        stockRepository.save(stock);

        return ResponseEntity.ok("在庫を追加しました！");
    }

    @PutMapping("/{id}")
    public Stock updateAllStocks(@PathVariable Long id,@Valid @RequestBody Stock stock){
        stock.id=id;
        return stockService.updateAllStock(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStocks(@PathVariable Long id){
        stockService.deleteStock(id);
    }
}
