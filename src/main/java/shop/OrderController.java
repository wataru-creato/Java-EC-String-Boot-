package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

        @Autowired
        private OrderService orderService;

        @GetMapping
        public List<Order> getAllOrders(){
            return orderService.getALLOrder();

        }

        @PostMapping
        public Order createOrders(@RequestBody Order order){

            return orderService.createAllOrder(order);
        }

        @PutMapping
        public Order updateOrders(@RequestBody Order order){

            return orderService.updateAllOrder(order);
        }

        @DeleteMapping("/{id}")
        public void  deleteOrders(@PathVariable Long id){
            orderService.deleteOrder(id);
        }

    }




