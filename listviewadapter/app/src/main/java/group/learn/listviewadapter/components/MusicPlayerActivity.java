package group.learn.listviewadapter.components;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import group.learn.listviewadapter.R;
import group.learn.listviewadapter.components.service.MusicService;

public class MusicPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        final Button startServiceButton = findViewById(R.id.start_btn);
        final Button endServiceButton = findViewById(R.id.stop_btn);
        final Spinner dropdownMode = findViewById(R.id.select_mode);
        final TextView txt = findViewById(R.id.textView_music_player);

        String[] items = new String[]{"START STICKY", "START NOT STICKY"};
        Intent serviceIntent = new Intent(getApplicationContext(), MusicService.class);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        dropdownMode.setAdapter(adapter);
        dropdownMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                serviceIntent.putExtra("select", items[position]);
            }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {
               serviceIntent.putExtra("select", "START NOT STICKY");
           }
           });

            startServiceButton.setOnClickListener(v -> startService(serviceIntent));

        endServiceButton.setOnClickListener(v -> stopService(serviceIntent));
    }
}