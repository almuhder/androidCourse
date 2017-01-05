package com.example.sqlitecontact;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.SyncStateContract.Helpers;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    MyHelper myHelper;
    EditText edUserName, edPassword, edSearch, edDelete;
    TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edUserName = (EditText) findViewById(R.id.editText1);
        edPassword = (EditText) findViewById(R.id.editText2);
        edSearch = (EditText) findViewById(R.id.edSearch1);
        tvCount = (TextView) findViewById(R.id.textViewCount);
        edDelete = (EditText) findViewById(R.id.edDelete);

        myHelper = new MyHelper(this, "ContactsDB", null, 1);
        tvCount.setText("There's: " + myHelper.getContactsCount() + " contacts right now");

        edDelete.setText("");
    }


    public void SaveContact(View v) {

        myHelper.addContact(edUserName.getText().toString(), edPassword.getText().toString());
        tvCount.setText("There's contacts: " + myHelper.getContactsCount() + " right now");
    }


    public void searchContact(View v) {
        int searchId = Integer.parseInt(edSearch.getText().toString());
        try {
            Contacts c = myHelper.Search(searchId);
            int id = c.getId();
            String name = c.getcName();
            String phone = c.getcPhone();
            Toast.makeText(this, "ID: " + id + "| Username: " + name + "| Phone: " + phone, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "invalid id ", Toast.LENGTH_SHORT).show();
        }

    }

    public void deleteContact(View v) {
        int id = Integer.parseInt(edDelete.getText().toString());
        myHelper.deleteContact(id);
        Toast.makeText(this, "Contact has been deleted .. " + id, Toast.LENGTH_SHORT).show();
        tvCount.setText("There's contacts: " + myHelper.getContactsCount() + " right now");

    }

    public void ShowAllContacts(View v) {
        Intent intent = new Intent(this, ShowAllActivity.class);
        startActivity(intent);
    }
}
