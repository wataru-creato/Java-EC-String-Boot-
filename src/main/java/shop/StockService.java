package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private  StockRepository stockRepository;

    public List<Stock> getAllStock(){
       return stockRepository.findAll();
    }

    public Stock createAllStock(Stock stock){
        return stockRepository.save(stock);
    }

    public Stock updateAllStock(Stock stock){
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id){
        stockRepository.deleteById(id);
    }
}
