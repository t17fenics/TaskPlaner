package com.example.taskplaner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> posts;
    ArrayAdapter<String> arrayAdapter;// = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, posts);
    ListView listView;



    //final ArrayList<String> posts = new ArrayList();


    //ListView listView = findViewById(R.id.listView);

    EditText taskEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        posts = new ArrayList();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, posts);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setStroke(2, Color.BLACK);
        listView.setBackground(drawable);

        listView.setAdapter(arrayAdapter);


        taskEditText = findViewById(R.id.editText);

        //final ArrayList<String> posts = new ArrayList();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String phone = arrayAdapter.getItem(position);
                arrayAdapter.remove(phone);
            }
        });

        //public void createTask(View view) {

    }
    public void createTask(View view) {

        arrayAdapter.add(taskEditText.getText().toString());
        //TextView priceTextView = findViewById(R.id.priceTextView);
        listView.smoothScrollToPosition(posts.size()-1);
    }

    public void resizeListView(View view) {
        Log.d("resize", "resize");
        //listView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,400));
    }
}
