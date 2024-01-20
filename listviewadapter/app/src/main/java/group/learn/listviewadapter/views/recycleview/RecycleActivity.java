package group.learn.listviewadapter.views.recycleview;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.data.DummyData;
import group.learn.listviewadapter.data.Item;

import java.util.List;

public class RecycleActivity extends AppCompatActivity implements ItemClickListener {

    //Data Source
    List<Item> items = DummyData.ITEMS;

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You Choose " + items.get(pos).getItemName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);


        //Adapter view
        RecyclerView listView = findViewById(R.id.recyclerView);


        //Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        RecycleAdapter recycleAdapter = new RecycleAdapter(items);
        recycleAdapter.setClickListener(this);

        listView.setAdapter(recycleAdapter);
        listView.setLayoutManager(layoutManager);
    }
}