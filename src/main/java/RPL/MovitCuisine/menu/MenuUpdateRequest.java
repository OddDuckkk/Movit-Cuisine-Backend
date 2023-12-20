package RPL.MovitCuisine.menu;

import lombok.Data;

import java.util.List;

@Data
public class MenuUpdateRequest {
    private String menuName;
    private Long menuPrice;
    private List<String> menuCat;
    private String menuImage;
}