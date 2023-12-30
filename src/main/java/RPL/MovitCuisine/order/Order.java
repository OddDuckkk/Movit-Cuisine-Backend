package RPL.MovitCuisine.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time orderTime;

    private String customerName;
    private String customerPhone;

    @JsonManagedReference(value="order-ref")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

}

