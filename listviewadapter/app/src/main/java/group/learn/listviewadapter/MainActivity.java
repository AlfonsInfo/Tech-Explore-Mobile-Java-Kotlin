package group.learn.listviewadapter;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import group.learn.listviewadapter.views.basicadapter.BuiltInAdapterView;
import group.learn.listviewadapter.views.customadapter.CustomAdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button buttonNavigateListView = findViewById(R.id.btnNavigateListView);
        final Button buttonNavigateCustomListView = findViewById(R.id.btnNavigateCustomListView);

        navigate(buttonNavigateListView, new Intent(this, BuiltInAdapterView.class));
        navigate(buttonNavigateCustomListView, new Intent(this, CustomAdapterView.class));
    }

    private void navigate(Button buttonNavigateListView, Intent intentToTargetActivity) {
        buttonNavigateListView.setOnClickListener(v -> startActivity(intentToTargetActivity));
    }
}