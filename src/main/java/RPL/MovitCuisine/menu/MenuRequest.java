package RPL.MovitCuisine.menu;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class MenuRequest {
        private String menuName;
        private Long menuPrice;
        private List<String> menuCat;
        private String menuImage;

}
