package RPL.MovitCuisine.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // GET ALL ORDERS API /api/v1/orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
    // END
    // GET ONE ORDER API "/api/v1/orders/{orderId}"
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        Order order = orderService.getOrderById(orderId);
        return order != null
                ? ResponseEntity.ok(order)
                : ResponseEntity.notFound().build();
    }
    // END
    // CREATE ORDER API "/api/v1/orders/insert"
    @PostMapping("/insert")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        Order createdOrder = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }
    // END
    // UPDATE ORDER API "/api/v1/orders/update/{orderId}"
    @PutMapping("/update/{orderId}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody OrderUpdateRequest updateRequest) {
        Order updatedOrder = orderService.updateOrder(orderId, updateRequest);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }
    // END
    // DELETE ORDER API "/api/v1/orders/delete/{orderId}"
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // END
}
