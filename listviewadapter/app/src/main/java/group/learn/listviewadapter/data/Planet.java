package group.learn.listviewadapter.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    private String planetName;
    private String moonCount;
    private int planetImage;


}
