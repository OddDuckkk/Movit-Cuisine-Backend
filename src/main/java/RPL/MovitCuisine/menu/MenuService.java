package RPL.MovitCuisine.menu;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    private MenuRequest menuRequest;

    //ALL MENU START
    public List<Menu> allMenus() {
        return menuRepository.findAll();
    }
    //ALL MENU END

    //SEARCH MENU START
    List<Menu> searchMenu(String query) {
        List<Menu> menus = menuRepository.searchMenu(query);
        return menus;
    }
    //SEARCH MENU END

    public List<Menu> searchMenuByCat(List<String> cat) {
        List<Menu> menus = menuRepository.findByMenuCatIn(cat);
        return menus;
    }

    public Menu createMenu(MenuRequest menuRequest) {

        Menu newMenu = new Menu();
        newMenu.setMenuName(menuRequest.getMenuName());
        newMenu.setMenuPrice(menuRequest.getMenuPrice());
        newMenu.setMenuCat(menuRequest.getMenuCat());
        newMenu.setMenuImage(menuRequest.getMenuImage());

        return menuRepository.save(newMenu);
    }

    public Menu updateMenu(Long menuId, MenuUpdateRequest updateRequest) {
        Menu existingMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + menuId));

        if (updateRequest.getMenuName() != null) {
            existingMenu.setMenuName(updateRequest.getMenuName());
        }
        if (updateRequest.getMenuPrice() != null) {
            existingMenu.setMenuPrice(updateRequest.getMenuPrice());
        }
        if (updateRequest.getMenuCat() != null) {
            existingMenu.setMenuCat(updateRequest.getMenuCat());
        }
        if (updateRequest.getMenuImage() != null) {
            existingMenu.setMenuImage(updateRequest.getMenuImage());
        }

        return menuRepository.save(existingMenu);
    }

    public void deleteMenu(Long menuId) {
        menuRepository.findById(menuId)
                .ifPresent(menu -> menuRepository.delete(menu));
    }
    public Optional<Menu> getMenuByMenuId(Long menuId) {
        return menuRepository.findMenuByMenuId(menuId);
    }

}
