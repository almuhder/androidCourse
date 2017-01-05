package majdeddin.com.testsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MajdEddin on 9/11/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    Context mContext;
    String DBName = "TestDB";
    int version = 1;
    SQLiteDatabase bridge;


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "Create Table Users ( _id integer primary key, username text, password text )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void addUser() {
        try {
            bridge = getWritableDatabase();
            String sql = "insert into Users (username, password) values ('MajdEddin', '123456') ";
            bridge.execSQL(sql);
            Toast.makeText(mContext, "Inserted successfully!!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(mContext, "Error!!", Toast.LENGTH_LONG).show();
        }
    }

    public void addUser(String username, String password) {
        try {
            bridge = getWritableDatabase();
            String sql = "insert into Users (username, password) values ('" + username + "', '" + password + "') ";
            bridge.execSQL(sql);
            Toast.makeText(mContext, "Inserted successfully!!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(mContext, "Error!!", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteUser(int id) {
        try {
            bridge = getWritableDatabase();
            String sql = "delete from Users where _id=" + id;
            bridge.execSQL(sql);
            Toast.makeText(mContext, "Deleted successfully!!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(mContext, "Error delete!!", Toast.LENGTH_LONG).show();
        }
    }

    public void getUsersCount() {
        try {
            bridge = getReadableDatabase();
            String sql = "select count(*) from Users";


            Cursor cursor = bridge.rawQuery(sql, null);
            int count = 0;
            if (cursor.moveToFirst())
                count = cursor.getInt(0);

            Toast.makeText(mContext, "The Count is: " + count, Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(mContext, "Error get Count!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void showUser(int id) {
        try {
            bridge = getReadableDatabase();
            String sql = "select * from Users where _id = " + id;


            String result = "";
            Cursor cursor = bridge.rawQuery(sql, null);
            int count = 0;
            if (cursor.moveToFirst())
                result = cursor.getInt(0) + "\n Username:  " + cursor.getString(1) + "\n Password:  " + cursor.getString(2);
            Toast.makeText(mContext, "The Count is: " + result, Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(mContext, "Error in selecting users", Toast.LENGTH_SHORT).show();
        }

    }

    public void updateUsers(int id, String username, String password) {
        try {
            bridge = getWritableDatabase();
            String sql = "update Users set username = '" + username + "' , password = '" + password + "' WHERE _id = " + id;
            bridge.execSQL(sql);
            Toast.makeText(mContext, "updated successfully!!", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(mContext, "Error!!", Toast.LENGTH_SHORT).show();
        }
    }


    public List<User> showListUsers() {

        List<User> list = new ArrayList<User>();
        bridge = getReadableDatabase();
        String sql = "Select * from Users ";

        int uid = 0;
        String uname = null;
        String upass = null;

        Cursor cursor = bridge.rawQuery(sql, null);
        cursor.moveToFirst();
        do{
            uid = cursor.getInt(0);
            uname = cursor.getString(1);
            upass = cursor.getString(2);

            User user = new User();
            user.setId(uid);
            user.setUsername(uname);
            user.setPassword(upass);
            list.add(user);
        }
        while (cursor.moveToNext()) ;


        return list;


    }


}
