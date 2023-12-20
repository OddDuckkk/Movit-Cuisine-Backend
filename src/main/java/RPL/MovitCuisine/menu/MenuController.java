package RPL.MovitCuisine.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {
    @Autowired
    private MenuService menuService;

    //GET ALL MENU API /api/v1/menu
    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenu() {
        return new ResponseEntity<List<Menu>>(menuService.allMenus(), HttpStatus.OK);
    }
    //END

    //GET ONE MENU API "/api/v1/menu/{menuId}"
    @GetMapping("/{menuId}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long menuId){
        Optional<Menu> requestedMenu = menuService.getMenuByMenuId(menuId);
        return requestedMenu.map(menu -> ResponseEntity.ok(menu))
                .orElseGet(() -> ResponseEntity.notFound().build());
        }
    //END

    //GET SEARCH MENU API "/api/v1/menu/search"
    @GetMapping("/search")
    public ResponseEntity<List<Menu>> searchMenu(@RequestParam("query") String query) {
        return ResponseEntity.ok(menuService.searchMenu(query));
    }
    //END

    //GET CATEGORY MENU API "/api/v1/menu/categories"
    @GetMapping("/categories")
    public ResponseEntity<List<Menu>> searchMenuByCat(@RequestParam("cat") List<String> cat) {
        return ResponseEntity.ok(menuService.searchMenuByCat(cat));
    }
    //END

    //POST INSERT MENU API "/api/v1/menu/admin/insert"
    @PostMapping("/admin/insert")
    public ResponseEntity<Menu> createMenu(@RequestBody MenuRequest menuRequest) {
        Menu createdMenu = menuService.createMenu(menuRequest);
        return new ResponseEntity<>(createdMenu, HttpStatus.CREATED);
    }
    //END

    //PUT UPDATE MENU API "/api/v1/menu/admin/update/{menuId}"
    @PutMapping("/admin/update/{menuId}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long menuId, @RequestBody MenuUpdateRequest updateRequest) {
        Menu updatedMenu = menuService.updateMenu(menuId, updateRequest);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }
    //END

    //DELETE MENU API "/api/v1/admin/delete/{menuId}"
    @DeleteMapping ("/admin/delete/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId) {
        menuService.deleteMenu(menuId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //END
}
