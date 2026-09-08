package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    public StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks(){
        return stockService.getAllStock();
    }

    @PostMapping
    public Stock createAllStocks(@RequestBody Stock stock){
        return stockService.createAllStock(stock);
    }

    @PutMapping
    public Stock updateAllStocks(@RequestBody Stock stock){
        return stockService.updateAllStock(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStocks(@PathVariable Long id){
        stockService.deleteStock(id);
    }
}
