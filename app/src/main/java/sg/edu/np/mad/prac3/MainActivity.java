package sg.edu.np.mad.prac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myFollowButton = findViewById(R.id.followbutton);
        TextView profileName = findViewById(R.id.textView);
        Random ran = new Random();   //calling random class assigning to a variable random
        int value = ran.nextInt(999999);
        String profileNameText = (String) profileName.getText();
        profileName.setText(profileNameText + value);

        myFollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = (String) myFollowButton.getText();

                if(buttonText == "FOLLOW"){
                    Log.v(TAG, "Followed user!");
                    myFollowButton.setText("UNFOLLOW");
                    Toast.makeText(MainActivity.this,"Followed user!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.v(TAG, "Unfollowed user!");
                    myFollowButton.setText("FOLLOW");
                    Toast.makeText(MainActivity.this,"Unfollowed user!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}