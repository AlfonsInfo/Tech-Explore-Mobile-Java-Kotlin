package group.learn.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ClickHandler {
    Context context;

    public ClickHandler(Context context) {
        this.context = context;
    }

    public void onButtonClicked(View view){
        Toast.makeText(context,"First Button Clicked",Toast.LENGTH_SHORT).show();
    } 
}
