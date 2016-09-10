package com.onyshchenko.artem.adaptersandlistcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class SimpleListViewWithCheckBoxActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String [] items = {"apple", "redberry", "blackberry"};
    private final static String TAG = "DEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        listView = (ListView)findViewById(R.id.checkBoxListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, Arrays.asList(items));
        listView.setAdapter(adapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemValue = (String)listView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), itemValue, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void doClick(View view) {
        SparseBooleanArray viewItems = listView.getCheckedItemPositions();
        for(int i=0; i < listView.getCount(); i++) {
            if(viewItems.get(i)) {
                String selectedColor = (String)listView.getItemAtPosition(i);
                Log.d(TAG, selectedColor);
            }
        }
    }
}
