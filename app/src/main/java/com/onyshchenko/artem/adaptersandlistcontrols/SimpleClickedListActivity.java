package com.onyshchenko.artem.adaptersandlistcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class SimpleClickedListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String [] items = {"apple", "redberry", "blackberry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_clicked_list);
        adapter = new ArrayAdapter<String>(this, R.layout.simple_list_row ,R.id.simpleRowTxtView, Arrays.asList(items));
        listView = (ListView)findViewById(R.id.simpleListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemValue = (String)listView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }
}
