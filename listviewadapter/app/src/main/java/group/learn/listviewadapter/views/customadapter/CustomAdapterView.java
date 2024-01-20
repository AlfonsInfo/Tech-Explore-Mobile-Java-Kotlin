package group.learn.listviewadapter.views.customadapter;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.data.DummyData;

import java.util.List;

public class CustomAdapterView extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_view);


        //AdapterView
        listView = findViewById(R.id.list_item);

        //Data Sources
        List<String> data = DummyData.NAMES;

        //Adapter
        CustomAdapter<String> adapter = new CustomAdapter<>(
                this,
                data
        );
        listView.setAdapter(adapter);
    }
}