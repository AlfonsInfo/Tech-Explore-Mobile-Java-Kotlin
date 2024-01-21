package group.learn.listviewadapter.components.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import java.util.Objects;

public class MusicService extends Service {

    private MediaPlayer player;
    public MusicService() {
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if(Objects.nonNull(player)){
            player.stop();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(
                this,
                Settings.System.DEFAULT_RINGTONE_URI
        );

        player.setLooping(true);
        player.start();

        Bundle bundle = intent.getExtras();
        if(bundle.containsKey("selected")){
            String key = bundle.getString("selected");
            if(Objects.equals("START STICKY", key)){
                Log.i("debugging", "onStartCommand: START STICKY ");
                return START_STICKY;
            }
        }

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}