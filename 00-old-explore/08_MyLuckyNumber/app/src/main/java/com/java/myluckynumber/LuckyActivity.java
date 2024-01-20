    package com.java.myluckynumber;

    import androidx.appcompat.app.AppCompatActivity;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.Random;

    public class LuckyActivity extends AppCompatActivity {

        TextView welcomeText, LuckyResult;
        Button ShareBtn;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lucky);

            welcomeText = findViewById(R.id.titleActivity);
            LuckyResult = findViewById(R.id.tvLuckyResult);
            ShareBtn = findViewById(R.id.btnShare);

            int randomNumber = generateRandomNumber();
            String userName = getName();
    
            showWelcomeToast(userName);
            showRandomNumber(randomNumber);

            ShareBtn.setOnClickListener(v->{
                shareData(userName,randomNumber);
            });
        }


        public void showWelcomeToast(String userName){
            Toast.makeText(this, "Welcome " + userName, Toast.LENGTH_LONG).show();
        }

        @SuppressLint("SetTextI18n")
        public void showRandomNumber(int number){
            //kayaknya ga perlu pake params tp harusnya lebih aman pake params.
            LuckyResult.setText(""+number);
        }


        //Getter and Generate Data
        public int generateRandomNumber(){
            Random random = new Random();
            int upper_limit = 1000;
            return random.nextInt(upper_limit);
        }

        public String getName(){
            //* dapatkan intent yang telah dibuat (tidak dibuat ulang)
            //Get intent return the intent that started this activity
            Intent i = getIntent();
            return i.getStringExtra("nama");

        }

        public void shareData(String username, int randomNumber){
            //Implicit Intern
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, username);
            i.putExtra(Intent.EXTRA_TEXT, "Hello My Lucky Number is" + randomNumber );
            startActivity(Intent.createChooser(i,"Choose a platform"));
        }
    }