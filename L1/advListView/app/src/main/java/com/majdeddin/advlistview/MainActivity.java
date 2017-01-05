package com.majdeddin.advlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int postionIndex = 0;
    ListView listView;
    CustomAdapter customAdapter;
    ArrayList<Contact> contactsList = new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        contactsList.add(new Contact("MajdEddin", "079587787", R.drawable.user));
        contactsList.add(new Contact("Obada", "07845126877", R.drawable.user));
        contactsList.add(new Contact("Yaman", "0787878787", R.drawable.user));
        contactsList.add(new Contact("MHD", "08778787787", R.drawable.user));
        contactsList.add(new Contact("Ahmad", "077788881", R.drawable.user));
        contactsList.add(new Contact("Omar", "077887777", R.drawable.user));
        customAdapter = new CustomAdapter(contactsList);
        listView.setAdapter(customAdapter);


    }

    public class CustomAdapter extends BaseAdapter {


        ArrayList<Contact> contactsList = new ArrayList<Contact>();


        public CustomAdapter(ArrayList<Contact> contactsList) {
            this.contactsList = contactsList;
        }


        @Override
        public int getCount() {
            return contactsList.size();
        }

        @Override
        public String getItem(int i) {
            return contactsList.get(i).getName();
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view1 = layoutInflater.inflate(R.layout.row_item, null);
            TextView tvName = (TextView) view1.findViewById(R.id.textView);
            tvName.setText(contactsList.get(i).getName());
            TextView tvPhone = (TextView) view1.findViewById(R.id.textView2);
            tvPhone.setText(contactsList.get(i).getPhone());
            ImageView image = (ImageView) view1.findViewById(R.id.imageView);
            image.setImageResource(contactsList.get(i).getImage());
            Button b = (Button) view1.findViewById(R.id.button);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "Item No." + i, Toast.LENGTH_SHORT).show();
                }
            });
            return view1;
        }
    }

}
