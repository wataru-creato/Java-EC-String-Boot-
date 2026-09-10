package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

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
        public Order createOrders(@Valid @RequestBody Order order){

            return orderService.createAllOrder(order);
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




