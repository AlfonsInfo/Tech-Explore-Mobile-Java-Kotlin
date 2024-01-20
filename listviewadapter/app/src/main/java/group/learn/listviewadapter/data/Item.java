package group.learn.listviewadapter.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int itemImg;
    private String itemName;
    private String itemDesc;


}
