package com.alljedi.bottomnavigationapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle=getIntent().getExtras();
        //int id=bundle.getInt("id");
        String title = bundle.getString("title");
        String author = bundle.getString("author");
        String summary = bundle.getString("summary");

        TextView titleText=(TextView) findViewById(R.id.title);
        titleText.setText(title);
        TextView authorText=(TextView) findViewById(R.id.author);
        authorText.setText(author);
        TextView summaryText=(TextView) findViewById(R.id.summary);
        summaryText.setText(summary);

    }
}
