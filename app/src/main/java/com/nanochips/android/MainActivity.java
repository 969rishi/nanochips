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
    private TextView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.message_textview);
        RecyclerView recyclerView = findViewById(R.id.nanochips_tags_recyclerview);
        ArrayList<String> list = new ArrayList<>();
        list.add("Mango");
        list.add("Grapes");
        list.add("Banana");
        list.add("Avocados");
        list.add("Dragon Fruit");
        list.add("strawberries");
        list.add("blueberries");
        new NanoChipClass(MainActivity.this, recyclerView, list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = NanoChipClass.getAllChipsValues();
                for (int i = 0; i < list.size(); i++) {
                    Log.d(TAG, "Values = " + list.get(i));
                }
            }
        });
    }
}
