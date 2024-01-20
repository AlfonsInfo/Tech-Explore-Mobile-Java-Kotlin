package group.learn.listviewadapter.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Shape {
    private int shapeImg;
    private String shapeName;
}
