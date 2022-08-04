package sg.edu.np.mad.prac3;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{
    private ArrayList<User> usersList;
    Context c;

    public recyclerAdapter(ArrayList<User> usersList, Context c){
        this.usersList = usersList;
        this.c = c;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nametxt;
        private TextView descriptiontxt;
        private ImageView image;

        public MyViewHolder(final View view){
            super(view);
            nametxt = view.findViewById(R.id.textView4);
            descriptiontxt = view.findViewById(R.id.textView5);
            image = view.findViewById(R.id.imageView4);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position%5==0)?0:1; //
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getName();
        holder.nametxt.setText(name);
        String description = usersList.get(position).getDescription();
        holder.descriptiontxt.setText(description);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //alertdialog
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("Profile");
                builder.setMessage(name);
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent intent = new Intent(c, MainActivity.class);
                        intent.putExtra("name", holder.nametxt.getText().toString());
                        intent.putExtra("description", holder.descriptiontxt.getText().toString());
                        c.startActivity(intent);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
