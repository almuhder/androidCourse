package com.example.admin.listviewwithimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {


    TextView contactName, contactPhone, contactDesc;
    ImageView contactPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        contactDesc = (TextView) findViewById(R.id.contactDesc);
        contactName = (TextView) findViewById(R.id.contactName);
        contactPhone = (TextView) findViewById(R.id.contactPhone);
        contactPhoto = (ImageView) findViewById(R.id.imageView2);



        Contact x = (Contact) getIntent().getSerializableExtra("selectedContact");
        contactDesc.setText(x.desc);
        contactName.setText(x.name);
        contactPhone.setText(x.phone);
        contactPhoto.setImageResource(x.photo);


    }
}
