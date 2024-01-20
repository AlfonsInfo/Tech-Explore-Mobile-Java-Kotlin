package group.learn.listviewadapter.views.gridview;

import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.data.DummyData;
import group.learn.listviewadapter.data.Shape;

import java.util.List;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        //AdapterView
        GridView gridView = findViewById(R.id.gridView);


        //Data Source
        List<Shape> shapes = DummyData.SHAPES;


        GridAdapter gridAdapter = new GridAdapter(this, shapes);

        gridView.setNumColumns(2);
        gridView.setAdapter(gridAdapter);

    }
}