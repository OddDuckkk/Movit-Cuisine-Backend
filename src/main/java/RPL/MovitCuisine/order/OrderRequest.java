package RPL.MovitCuisine.order;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class OrderRequest {
    private String customerName;
    private String customerPhone;
    private List<OrderItem> orderItems;
}