package com.onyshchenko.artem.adaptersandlistcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleListActivity extends AppCompatActivity {

    private String [] items = {"apple", "redberry", "blackberry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView)findViewById(R.id.simpleListView);
        listView.setAdapter(adapter);
    }
}
