package group.learn.listviewadapter.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Music {
    private String title;
    private String genre;
}
