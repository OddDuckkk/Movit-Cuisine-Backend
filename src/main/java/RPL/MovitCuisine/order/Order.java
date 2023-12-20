package RPL.MovitCuisine.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Order {
    @Id
    private String orderId;
    private LocalDate orderDate;
    private LocalTime orderTime;

}
