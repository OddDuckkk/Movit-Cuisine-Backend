package RPL.MovitCuisine.table;

import RPL.MovitCuisine.menu.Menu;
import RPL.MovitCuisine.menu.MenuRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    private TableRequest tableRequest;
    public List<Table> allTables() {
        return tableRepository.findAll();
    }

    public Table createTable(TableRequest tableRequest) {
        Table newTable = new Table();
        newTable.setTableName(tableRequest.getTableName());
        newTable.setTableCapacity(tableRequest.getTableCapacity());
        newTable.setTableImage(tableRequest.getTableImage());

        return tableRepository.save(newTable);
    }

    public Table updateTable(Long tableId, TableUpdateRequest updateRequest) {
        Table existingTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new EntityNotFoundException("Table not found with id: " + tableId));

        if (updateRequest.getTableName() != null) {
            existingTable.setTableName(updateRequest.getTableName());
        }
        if (updateRequest.getTableCapacity() != null) {
            existingTable.setTableCapacity(updateRequest.getTableCapacity());
        }
        if (updateRequest.getTableImage() != null) {
            existingTable.setTableImage(updateRequest.getTableImage());
        }

        return tableRepository.save(existingTable);
    }

    public void deleteTable(Long tableId) {
        tableRepository.findById(tableId)
                .ifPresent(menu -> tableRepository.delete(menu));
    }
}

