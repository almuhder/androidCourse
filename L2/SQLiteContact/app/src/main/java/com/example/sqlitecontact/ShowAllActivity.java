package com.example.sqlitecontact;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowAllActivity extends Activity {

    ListView listViewContact;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        myHelper = new MyHelper(this, "ContactsDB", null, 1);


        listViewContact = (ListView) findViewById(R.id.listViewContacts);

        List<Contacts> list = myHelper.ShowListContacts();

        ArrayAdapter<Contacts> adapter = new ArrayAdapter<Contacts>
                (this, android.R.layout.simple_list_item_1, list);

        listViewContact.setAdapter(adapter);
    }
}
