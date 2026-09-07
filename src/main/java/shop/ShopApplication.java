package shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	// アプリ起動時に動いて、データベースにデータを保存するコード
	@Bean
	public CommandLineRunner demo(ProductRepository productRepository,
								  StockRepository stockRepository,
								  CartRepository cartRepository,
								  UserRepository userRepository,
								  OrderRepository orderRepository) {
		return (args) -> {
			// 商品データを作成
			Product product = new Product("P001", "美味しいお茶", 500, "静岡県産の上質な緑茶です。", "飲料");
			productRepository.save(product);

			Stock stock=new Stock("P001",500);
			stockRepository.save(stock);

			Cart cart=new Cart("001","001",3);
			cartRepository.save(cart);

			User user=new User("001","田中","@gmail.com","admin","東京","080");
			userRepository.save(user);

			LocalDate orderDay = LocalDate.of(2026, 4, 1);
			Order order=new Order("001","001",orderDay,500,20,"food");
			orderRepository.save(order);
//			return "注文ID: " + orderId + ", ユーザーID: " + user_id + ", 注文日: " + order_day + ", 単価: " + purchasePrice + "円" + ", 数量: " + quantity + ", ステータス: " + orderState;


			System.out.println(">>> データをデータベースに保存しました！ <<<");
		};
	}
}