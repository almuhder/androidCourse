package com.majdeddin.advgridview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CustomAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, SingleItemActivity.class);
                intent.putExtra("item_id", String.valueOf(i));
                startActivity(intent);
            }
        });
    }

    // inner class
    public class CustomAdapter extends BaseAdapter{

        Context context;
        ArrayList<SingleItem> items;

        // constructor
        public CustomAdapter(Context context){
            this.context = context;
            fillArray();
        }
        public void fillArray(){
            items = new ArrayList<>();
            items.add(new SingleItem(R.drawable.user, "A"));
            items.add(new SingleItem(R.drawable.user, "B"));
            items.add(new SingleItem(R.drawable.user, "C"));
            items.add(new SingleItem(R.drawable.user, "D"));
            items.add(new SingleItem(R.drawable.user, "E"));
            items.add(new SingleItem(R.drawable.user, "F"));

        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = getLayoutInflater();
            View view1 = inflater.inflate(R.layout.grid_item, null);
            ImageView imageView = (ImageView) view1.findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.user);
            TextView tvName= (TextView) view1.findViewById(R.id.textView);
            tvName.setText(items.get(i).name);

            return view1;
        }
    }
}
