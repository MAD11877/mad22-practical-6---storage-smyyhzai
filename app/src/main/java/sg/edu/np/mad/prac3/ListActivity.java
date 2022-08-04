package sg.edu.np.mad.prac3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private ArrayList<User> usersList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();

    }
    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(usersList,ListActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        for(int i = 0; i < 21; i++){
            Random ran = new Random();
            int value = ran.nextInt(999999);
            int value2 = ran.nextInt(9999999);
            usersList.add(new User("Name" + value, "Description" + value2, i, ran.nextBoolean()));
        }
    }
}