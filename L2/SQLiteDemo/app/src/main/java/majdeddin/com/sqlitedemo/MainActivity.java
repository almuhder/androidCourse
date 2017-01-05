package majdeddin.com.sqlitedemo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import majdeddin.com.db.Contact;
import majdeddin.com.db.ContactsDBOpenHelper;
import majdeddin.com.db.ContactsDataSource;

public class MainActivity extends AppCompatActivity {

    private static final String LOGCAT = "CONTACTSTAG";

    ContactsDataSource dataSource;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);


        dataSource = new ContactsDataSource(this);
        dataSource.open();


        List<Contact> contacts = dataSource.findAll();
        if (contacts.size() == 0) {
            createData();
            contacts = dataSource.findAll();

        }

        ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>
                (this,android.R.layout.simple_list_item_1,contacts);


        lv.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        dataSource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataSource.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createData() {
        Contact contact = new Contact();
        contact.setName("MajdEddin");
        contact.setMobile("0795999777");
        contact = dataSource.create(contact);
        Log.i(LOGCAT, "Contact created with id: " + contact.getId());


        contact.setName("Obada");
        contact.setMobile("0788999777");
        contact = dataSource.create(contact);
        Log.i(LOGCAT, "Contact created with id: " + contact.getId());


        contact.setName("Yaman");
        contact.setMobile("07775999777");
        contact = dataSource.create(contact);
        Log.i(LOGCAT, "Contact created with id: " + contact.getId());
    }
}
