package RPL.MovitCuisine.menu;

import RPL.MovitCuisine.order.OrderItem;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;
    private String menuName;
    private Long menuPrice;
    private List<String> menuCat;
    private String menuImage;

    @JsonManagedReference(value="menu-ref")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "menu_id")
    private List<OrderItem> orderItems;
}
