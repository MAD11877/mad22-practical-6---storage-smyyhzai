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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button followButton = findViewById(R.id.followbutton);
        TextView profileName = findViewById(R.id.textView);
        TextView profileDesc = findViewById(R.id.textView2);

        Intent receivingEnd = getIntent();
        String name = receivingEnd.getStringExtra("name");
        String desc = receivingEnd.getStringExtra("description");

        profileName.setText(name);
        profileDesc.setText(desc);

        Button mssgButton = findViewById(R.id.mssgbutton);
        mssgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent viewMessage = new Intent(MainActivity.this, MessageGroup2.class);
                startActivity(viewMessage);
            }
        });

        Button listAct = findViewById(R.id.listActButton);
        listAct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent viewList = new Intent(MainActivity.this, ListActivity.class);
                startActivity(viewList);
            }
        });

        followButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //User user = new User();
                //boolean followValue = user.getFollowed();

                if(followButton.getText().toString().equals("FOLLOW")){
                    Toast.makeText(MainActivity.this,"Followed user!", Toast.LENGTH_SHORT).show();
                    followButton.setText("UNFOLLOW");
                    //set follow value true/false
                    //followValue = true;
                }
                else if(followButton.getText().toString().equals("UNFOLLOW")){
                    followButton.setText("FOLLOW");
                    //followValue = false;
                    Toast.makeText(MainActivity.this,"Unfollowed user!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}