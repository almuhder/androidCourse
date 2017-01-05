package com.majdeddin.advgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SingleItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);

        TextView tvItem = (TextView) findViewById(R.id.itemTV);
        String value = getIntent().getExtras().getString("item_id");
        Toast.makeText(SingleItemActivity.this, value, Toast.LENGTH_SHORT).show();
        tvItem.setText(value);
    }
}
