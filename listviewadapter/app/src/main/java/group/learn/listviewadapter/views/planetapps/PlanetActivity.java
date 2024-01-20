package group.learn.listviewadapter.views.planetapps;

import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.data.DummyData;
import group.learn.listviewadapter.data.Planet;

import java.util.ArrayList;

public class PlanetActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planets;

    PlanetAdapter planetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        //AdapterView
        listView = findViewById(R.id.list_item);


        //data source
        planets = (ArrayList<Planet>) DummyData.PLANETS;


        //adapter
        planetAdapter = new PlanetAdapter(planets, getApplicationContext());

        //set adapterview -> adapter
        listView.setAdapter(planetAdapter);


        listView.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(this,"Planet Name" + planetAdapter.getItem(position).getPlanetName(),Toast.LENGTH_SHORT).show());



    }
}