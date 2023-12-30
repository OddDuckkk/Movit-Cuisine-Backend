package RPL.MovitCuisine.order;

import RPL.MovitCuisine.menu.Menu;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @JsonBackReference(value="menu-ref")
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @JsonBackReference(value="order-ref")
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int quantity;
}
