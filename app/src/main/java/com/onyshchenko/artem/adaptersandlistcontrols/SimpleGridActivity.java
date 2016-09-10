package com.onyshchenko.artem.adaptersandlistcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class SimpleGridActivity extends AppCompatActivity {

    private String [] items = {"apple", "redberry", "blackberry", "currantberry", "lime"};
    private GridView gridView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_grid);
        gridView = (GridView)findViewById(R.id.gridView1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        gridView.setAdapter(adapter);
    }
}
