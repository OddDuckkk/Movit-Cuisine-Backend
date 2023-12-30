package RPL.MovitCuisine.order;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
public class OrderRequest {
    private Date orderDate;
    private Time orderTime;
    private String customerName;
    private String customerPhone;
    private List<OrderItem> orderItems;
}