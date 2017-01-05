package com.example.admin.listviewwithimage;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Contact> listContact; // data
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listContact = fillTheList();

        listView = (ListView) findViewById(R.id.listView);
        adapter = new CustomAdapter(listContact);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "index: " + position, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this, ContactActivity.class);

                Contact currentContact  = listContact.get(position);
                i.putExtra("selectedContact", currentContact);

                startActivity(i);

            }
        });


    }

    public ArrayList<Contact> fillTheList(){
        listContact = new ArrayList<Contact>();
        listContact.add(new Contact("Essam","079223445",R.mipmap.ic_launcher,"this is a super essam "));
        listContact.add(new Contact("Obada","079223445",R.drawable.duck1,"this is a super obada "));
        listContact.add(new Contact("Raneem","079223445",R.drawable.duck2,"this is a super raneem "));
        listContact.add(new Contact("Yaman","079223445",R.mipmap.ic_launcher,"this is a super yaman "));
        listContact.add(new Contact("Mami","079223445",R.mipmap.ic_launcher,"this is a super mam "));
        listContact.add(new Contact("Babi","079223445",R.mipmap.ic_launcher,"this is a super dad "));
        listContact.add(new Contact("Yusuf","079223445",R.mipmap.ic_launcher,"this is a super student "));
        // connect to database
        // make a query
        // read query while ()
        return listContact;
    }

    public class CustomAdapter extends BaseAdapter{

        ArrayList<Contact> listContact = new ArrayList<Contact>(); // data

        public CustomAdapter(ArrayList<Contact> listContact){
            this.listContact = listContact;
        }


        @Override
        public int getCount() {
            // how many list item do we have
            return listContact.size(); // array.length
        }

        @Override
        public Object getItem(int position) {
            return listContact.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // will be executed for every contacts in the array list

            // layout/row_item.xml => Convert to view ???  => inflater
            LayoutInflater x = getLayoutInflater();

            View myView = x.inflate(R.layout.row_item, null);
            TextView tvName = (TextView) myView.findViewById(R.id.textView);
            TextView tvPhone = (TextView) myView.findViewById(R.id.textView2);
            ImageView imageView  = (ImageView) myView.findViewById(R.id.imageView);

            tvName.setText(listContact.get(position).name);
            if(listContact.get(position).name != "Yaman") {
                tvPhone.setText(listContact.get(position).phone);
            }else{
                tvPhone.setText(listContact.get(position).phone= "");
            }
            imageView.setImageResource(listContact.get(position).photo);

            Button b = (Button) myView.findViewById(R.id.button);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getApplicationContext(), "Item: " + listContact.get(position).name, Toast.LENGTH_SHORT).show();
                    listContact.remove(position);
                    Toast.makeText(getApplicationContext(), "item has been deleted!! ", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }
            });
            return myView;
        }
    }
}
