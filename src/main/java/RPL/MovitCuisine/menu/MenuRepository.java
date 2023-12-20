package RPL.MovitCuisine.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    //SEARCH MENU START
    @Query("SELECT m FROM Menu m WHERE " +
            "m.menuName LIKE CONCAT('%',:query, '%')")
    List<Menu> searchMenu(String query);
    //SEARCH MENU END
    List<Menu> findByMenuCatIn(List<String> cat);

    Optional<Menu> findMenuByMenuId(Long menuId);

}
