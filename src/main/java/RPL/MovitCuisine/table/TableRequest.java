package RPL.MovitCuisine.table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class TableRequest {
    private String tableName;
    private Integer tableCapacity;
    private String tableImage;
}
