package RPL.MovitCuisine.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private OrderRequest orderRequest;
    private OrderUpdateRequest orderUpdateRequest;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderDate(orderRequest.getOrderDate());
        order.setOrderTime(orderRequest.getOrderTime());
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerPhone(orderRequest.getCustomerPhone());
        order.setOrderItems(orderRequest.getOrderItems());


        order.getOrderItems().forEach(orderItem -> orderItem.setOrder(order));
        return orderRepository.save(order);
    }
    public Order updateOrder(Long orderId, OrderUpdateRequest updateRequest) {

        Optional<Order> existingOrderOptional = orderRepository.findById(orderId);

        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();

            // Map fields from the request to the order entity
            existingOrder.setOrderDate(orderUpdateRequest.getOrderDate());
            existingOrder.setOrderTime(orderUpdateRequest.getOrderTime());
            existingOrder.setCustomerName(orderUpdateRequest.getCustomerName());
            existingOrder.setCustomerPhone(orderRequest.getCustomerPhone());
            existingOrder.setOrderItems(orderRequest.getOrderItems());

            // Ensure order items are associated with the order
            existingOrder.getOrderItems().forEach(orderItem -> orderItem.setOrder(existingOrder));

            // You can perform any additional business logic/validation here
            return orderRepository.save(existingOrder);
        } else {
            // Handle not found case
            return null;
        }
    }
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
