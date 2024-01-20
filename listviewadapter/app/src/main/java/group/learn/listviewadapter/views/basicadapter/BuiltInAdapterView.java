package group.learn.listviewadapter.views.basicadapter;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.data.DummyData;

import java.util.List;

public class BuiltInAdapterView extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_built_in_adapter_view);


        //AdapterView
        listView = findViewById(R.id.list_item);

        //Data Sources
        List<String> data = DummyData.NAMES;

        //Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        listView.setAdapter(adapter);
    }
}