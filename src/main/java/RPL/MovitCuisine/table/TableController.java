package RPL.MovitCuisine.table;

import RPL.MovitCuisine.menu.Menu;
import RPL.MovitCuisine.menu.MenuRequest;
import RPL.MovitCuisine.menu.MenuUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/table")
public class TableController {
    @Autowired
    private TableService tableService;

    //GET ALL TABLE API "/api/v1/table"
    @GetMapping
    public ResponseEntity<List<Table>> getAllTable() {
        return new ResponseEntity<List<Table>>(tableService.allTables(), HttpStatus.OK);
    }
    //END

    //POST INSERT TABLE API "/api/v1/table/admin/insert"
    @PostMapping("/admin/insert")
    public ResponseEntity<Table> createTable (@RequestBody TableRequest tableRequest) {
        Table createdTable = tableService.createTable(tableRequest);
        return new ResponseEntity<>(createdTable, HttpStatus.CREATED);
    }
    //END

    //PUT UPDATE TABLE API "api/v1/table/admin/update/{tableId}"
    @PutMapping("/admin/update/{tableId}")
    public ResponseEntity<Table> updateTable(@PathVariable Long tableId, @RequestBody TableUpdateRequest updateRequest){
    Table updatedTable = tableService.updateTable(tableId, updateRequest);
    return new ResponseEntity<>(updatedTable, HttpStatus.OK);
    }
    //END

    // DELETE TABLE API "/api/v1/table/admin/delete/{tableId}"
    @DeleteMapping("/admin/delete/{tableId}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long tableId) {
        tableService.deleteTable(tableId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //END
}

