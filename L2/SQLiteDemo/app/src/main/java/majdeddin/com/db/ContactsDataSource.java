package majdeddin.com.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import majdeddin.com.db.ContactsDBOpenHelper;

/**
 * Created by MajdEddin on 8/28/15.
 */
public class ContactsDataSource {

    private static final String LOGCAT = "CONTACTSTAG";
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

    public static final String[] allColums = {
            ContactsDBOpenHelper.COLUMN_ID,
            ContactsDBOpenHelper.COLUMN_NAME,
            ContactsDBOpenHelper.COLUMN_MOBILE
    };


    //1. create constructor methods
    public ContactsDataSource(Context context) {

        dbHelper = new ContactsDBOpenHelper(context);

    }


    public Contact create(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(ContactsDBOpenHelper.COLUMN_NAME, contact.getName());
        values.put(ContactsDBOpenHelper.COLUMN_MOBILE, contact.getMobile());
        long insertId = database.insert(ContactsDBOpenHelper.TABLE_CONTACT, null, values);
        contact.setId(insertId);
        return contact;
    }


    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<Contact>();
        Cursor cursor = database.query(ContactsDBOpenHelper.TABLE_CONTACT, allColums,
                null, null, null, null, null);
        Log.i(LOGCAT, "Returned " + cursor.getCount() + " rows");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Contact contact = new Contact();
                contact.setId(cursor.getLong(cursor.getColumnIndex(ContactsDBOpenHelper.COLUMN_ID)));
                contact.setName(cursor.getString(cursor.getColumnIndex(ContactsDBOpenHelper.COLUMN_NAME)));
                contact.setMobile(cursor.getString(cursor.getColumnIndex(ContactsDBOpenHelper.COLUMN_MOBILE)));
                contacts.add(contact);
            }
        }
        return contacts;
    }


    public void open() {
        Log.i(LOGCAT, "Open Database");
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        Log.i(LOGCAT, "Close Database");
        dbHelper.close();
    }
}
