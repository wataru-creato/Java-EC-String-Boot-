package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

        @Autowired
        private OrderService orderService;

        @Autowired
        public OrderRepository orderRepository;

        @Autowired
        public ProductRepository productRepository;

        @Autowired
        public UserRepository userRepository;

        @GetMapping
        public List<Order> getAllOrders(){
            return orderService.getALLOrder();

        }

        @PostMapping
        public ResponseEntity<?> createOrder(@RequestBody @Valid OrderRequest request) {
            // 1. productIdからProductを探す
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("商品が見つかりません"));

            // 2. userIdからUserを探す
            User user = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new RuntimeException("ユーザーが見つかりません"));

            // 3. Orderエンティティを作って紐づける
            Order order = new Order();
            order.setOrderId(request.getOrderId());
            order.setOrderState(request.getOrderState());
            order.setOrderDay(request.getOrderDay());
            order.setPurchasePrice(request.getPurchasePrice());
            order.setQuantity(request.getQuantity());
            order.setProduct(product);
            order.setUser(user);

            orderRepository.save(order);

            return ResponseEntity.ok("注文を登録しました！");
        }
        @PutMapping("/{id}")
        public Order updateOrders(@PathVariable Long id,@Valid @RequestBody Order order){
            order.id=id;
            return orderService.updateAllOrder(order);
        }

        @DeleteMapping("/{id}")
        public void  deleteOrders(@PathVariable Long id){
            orderService.deleteOrder(id);
        }

    }




