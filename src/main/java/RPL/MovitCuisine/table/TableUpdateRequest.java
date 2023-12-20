package RPL.MovitCuisine.table;

import lombok.Data;

@Data
public class TableUpdateRequest {
    private String tableName;
    private Integer tableCapacity;
    private String tableImage;
}
