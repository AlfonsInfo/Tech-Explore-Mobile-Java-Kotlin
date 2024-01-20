package group.learn.listviewadapter;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import group.learn.listviewadapter.views.basicadapter.BuiltInAdapterView;
import group.learn.listviewadapter.views.customadapter.CustomAdapterView;
import group.learn.listviewadapter.views.gridview.GridActivity;
import group.learn.listviewadapter.views.planetapps.PlanetActivity;
import group.learn.listviewadapter.views.recycleview.RecycleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button buttonNavigateListView = findViewById(R.id.btnNavigateListView);
        final Button buttonNavigateCustomListView = findViewById(R.id.btnNavigateCustomListView);
        final Button buttonNavigateToPlanetView = findViewById(R.id.btnNavigateToPlanet);
        final Button buttonNavigateToGridViews = findViewById(R.id.btnNavigateToGrid);
        final Button buttonNavigateToRecycleView = findViewById(R.id.btnNavigateToRecycle);

        doNavigate(buttonNavigateListView, new Intent(this, BuiltInAdapterView.class));
        doNavigate(buttonNavigateCustomListView, new Intent(this, CustomAdapterView.class));
        doNavigate(buttonNavigateToPlanetView, new Intent(this, PlanetActivity.class));
        doNavigate(buttonNavigateToGridViews, new Intent(this, GridActivity.class));
        doNavigate(buttonNavigateToRecycleView, new Intent(this, RecycleActivity.class));
    }

    private void doNavigate(Button buttonNavigateListView, Intent intentToTargetActivity) {
        buttonNavigateListView.setOnClickListener(v -> startActivity(intentToTargetActivity));
    }
}