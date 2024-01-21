package group.learn.listviewadapter.components.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.Toast;

import java.util.Objects;

public class SpeakerDownReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

            // Periksa volume speaker
            int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

            // Jika volume mencapai 0%, lakukan sesuatu
            if (currentVolume == 0) {
                Toast.makeText(context, "SPEAKER 0%", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
