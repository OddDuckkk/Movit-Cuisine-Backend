package RPL.MovitCuisine.order;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderUpdateRequest {
    private Date orderDate;
    private Date orderTime;
    private String customerName;
    private String customerPhone;
    private List<OrderItem> orderItems;
}
