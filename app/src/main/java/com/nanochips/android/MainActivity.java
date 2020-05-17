package com.nanochips.android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.nanochips.nanochips.NanoChipClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.message_textview);
        RecyclerView recyclerView = findViewById(R.id.custom_tags_recyclerview);
        new NanoChipClass(MainActivity.this, recyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = NanoChipClass.getAllChipsValues();

                Log.d(TAG, "onClick: lenght of nano chips " + list.size());
                for (String s : list) {
                    Log.d(TAG, "Values = " + s);
                }
            }
        });
    }
}
