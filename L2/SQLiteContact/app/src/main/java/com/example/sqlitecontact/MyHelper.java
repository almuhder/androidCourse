package com.example.sqlitecontact;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyHelper extends SQLiteOpenHelper {

    Context mContext;
    SQLiteDatabase bridge;
    String tableName = "Users";

    // Database Constant Values
    // private final static String DATABASE_NAME = "ContactDB";
    // private final static int DATABASE_Version = 1;

    public MyHelper(Context context, String name, CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String x = "Create table " + tableName
                + " (_id integer primary key,cName text,cPhone text)";
        db.execSQL(x);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(String cName, String CPhone) {
        bridge = getWritableDatabase();
        String sql = "Insert into " + tableName + "(cName, cPhone) values ('"
                + cName + "','" + CPhone + "')";
        bridge.execSQL(sql);
    }

    public int getContactsCount() {
        bridge = getReadableDatabase();
        String sql = "select count(*) from " + tableName;
        Cursor c = bridge.rawQuery(sql, null);

        int count = 0;
        if (c.moveToFirst()) {
            count = c.getInt(0);
        }
        return count;
    }

    public Contacts Search(int id) {
         bridge = getReadableDatabase();
        String x = "select * from " + tableName + " where _id=" + id;

        int uid = 0;
        String uname = null;
        String upwd = null;

        Cursor c = bridge.rawQuery(x, null);
        if (c.moveToFirst()) {
            uid = c.getInt(0);
            uname = c.getString(1);
            upwd = c.getString(2);
        }
        Contacts con = new Contacts();
        con.setId(uid);
        con.setcName(uname);
        con.setcPhone(upwd);
        return con;
    }

    public void showContact() {
        SQLiteDatabase bridge = getReadableDatabase();
        String sql = "select * from " + tableName + "where _id = 1";

        int uid = 0;
        String uname = null;
        String upwd = null;

        Cursor c = bridge.rawQuery(sql, null);
        if (c.moveToFirst())

        {
            uid = c.getInt(0);
            uname = c.getString(1);
            upwd = c.getString(2);
            Toast.makeText(mContext, uid + " " + uname + " " + upwd,
                    Toast.LENGTH_SHORT).show();
        }


    }

    public void deleteContact(int id) {
        SQLiteDatabase bridge = getWritableDatabase();
        String sql = "delete from " + tableName + " where  _id = " + id;
        bridge.execSQL(sql);
    }


    public List<Contacts> ShowListContacts() {
        List<Contacts> list = new ArrayList<Contacts>();
        SQLiteDatabase bridge = getReadableDatabase();
        String sql = "select * from " + tableName;
        int uid = 0;
        String uname = null;
        String upwd = null;

        Cursor c = bridge.rawQuery(sql, null);
        c.moveToFirst();
        do {
            uid = c.getInt(0);
            uname = c.getString(1);
            upwd = c.getString(2);

            Contacts cont = new Contacts();
            cont.setId(uid);
            cont.setcName(uname);
            cont.setcPhone(upwd);
            list.add(cont);
        }
        while (c.moveToNext());
        return list;

    }
}
