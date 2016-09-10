package com.onyshchenko.artem.adaptersandlistcontrols;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.onyshchenko.artem.adaptersandlistcontrols.model.UserInfo;


public class SimpleCustomAdapterActivity extends AppCompatActivity {

    private ListView listView;
    private final static UserInfo[] users = {new UserInfo("Artem", "Onyshchenko", 20), new UserInfo("Leo", "Messi", 30)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        listView = (ListView)findViewById(R.id.customAdapterListView);
        UserInfoAdapter userInfoAdapter = new UserInfoAdapter(this, users);
        listView.setAdapter(userInfoAdapter);
    }

    public static class UserInfoAdapter extends BaseAdapter {

        private final Context context;
        private LayoutInflater inflater;
        private final UserInfo [] userInfos;

        public UserInfoAdapter(Context context, UserInfo [] userInfos) {
            this.context = context;
            this.userInfos = userInfos;
            inflater = LayoutInflater.from(this.context);
        }

        static class ViewHolder {
            TextView nameTxtView;
            TextView surnameTxtView;
            TextView yearTxtView;
        }

        @Override
        public int getCount() {
            return userInfos.length;
        }

        public int getViewTypeCount() {
            return 1; //because I have only TextView
        }

        @Override
        public Object getItem(int i) {
            return userInfos[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_row_for_custom_adapter, null);
                holder = new ViewHolder();
                holder.nameTxtView = (TextView)convertView.findViewById(R.id.nameTxt);
                holder.surnameTxtView = (TextView)convertView.findViewById(R.id.surnameTxt);
                holder.yearTxtView = (TextView)convertView.findViewById(R.id.yearTxt);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.nameTxtView.setText(userInfos[position].getName());
            holder.surnameTxtView.setText(userInfos[position].getSurname());
            holder.yearTxtView.setText(userInfos[position].getYear().toString());
            return convertView;
        }
        //getTag and SetTag are basically a way for views to get memory
    }
}
