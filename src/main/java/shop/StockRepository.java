package shop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
    // これだけで、データの保存（save）や検索（findAll等）の機能が自動で備わります
}