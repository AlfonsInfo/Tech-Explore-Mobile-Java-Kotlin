package group.learn.listviewadapter;

import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import group.learn.listviewadapter.components.MusicPlayerActivity;
import group.learn.listviewadapter.components.broadcast.AirplaneModeReceiver;
import group.learn.listviewadapter.components.broadcast.SpeakerDownReceiver;
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
        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        IntentFilter intentFilter2 = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        AirplaneModeReceiver br = new AirplaneModeReceiver();
        SpeakerDownReceiver br2 = new SpeakerDownReceiver();
        registerReceiver(br, intentFilter);
        registerReceiver(br2, intentFilter2);

        final Button buttonNavigateListView = findViewById(R.id.btnNavigateListView);
        final Button buttonNavigateCustomListView = findViewById(R.id.btnNavigateCustomListView);
        final Button buttonNavigateToPlanetView = findViewById(R.id.btnNavigateToPlanet);
        final Button buttonNavigateToGridViews = findViewById(R.id.btnNavigateToGrid);
        final Button buttonNavigateToRecycleView = findViewById(R.id.btnNavigateToRecycle);
        final Button buttonNavigateToMusicPlayer = findViewById(R.id.btnNavigateToMusicPlayer);

        doNavigate(buttonNavigateListView, new Intent(this, BuiltInAdapterView.class));
        doNavigate(buttonNavigateCustomListView, new Intent(this, CustomAdapterView.class));
        doNavigate(buttonNavigateToPlanetView, new Intent(this, PlanetActivity.class));
        doNavigate(buttonNavigateToGridViews, new Intent(this, GridActivity.class));
        doNavigate(buttonNavigateToRecycleView, new Intent(this, RecycleActivity.class));
        doNavigate(buttonNavigateToMusicPlayer, new Intent(this, MusicPlayerActivity.class));
    }

    private void doNavigate(Button buttonNavigateListView, Intent intentToTargetActivity) {
        buttonNavigateListView.setOnClickListener(v -> startActivity(intentToTargetActivity));
    }
}