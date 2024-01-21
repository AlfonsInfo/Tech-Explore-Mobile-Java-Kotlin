package group.learn.listviewadapter.components.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Objects;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Objects.nonNull(intent.getAction()) && Objects.equals(intent.getAction(),Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            boolean isAirplaneModeOn = intent.getBooleanExtra("state",false);
            String msg = isAirplaneModeOn ? "Airplane mode ON " : "Airplane mode OFF ";
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
