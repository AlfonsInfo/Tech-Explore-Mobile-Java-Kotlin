package group.learn.databinding;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import group.learn.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Person person = new Person();
        person.setName("Alfons");
        person.setEmail("example@gmail.com");
        ClickHandler clickHandler = new ClickHandler(this);
        activityMainBinding.setPerson(person);
        activityMainBinding.setClickHandler(clickHandler);
    }
}