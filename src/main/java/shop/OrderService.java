package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {

    @Autowired
    private  OrderRepository orderRepository;

    public List<Order> getALLOrder(){

        return orderRepository.findAll();
    }

    public Order createAllOrder(Order order){

        return orderRepository.save(order);
    }

    public Order updateAllOrder(Order order){
        return orderRepository.save(order);
    }
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}





