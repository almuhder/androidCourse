package majdeddin.com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MajdEddin on 8/28/15.
 */
public class ContactsDBOpenHelper extends SQLiteOpenHelper {


    public static final String LOGCAT = "CONTACTSTAG";

    private static final String DATABASE_NAME = "contact.db";
    private static final int DATABASE_VERSION = 6;

    public static final String TABLE_CONTACT = "contacts";
    public static final String COLUMN_ID = "contactId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MOBILE = "mobile";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_CONTACT + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_MOBILE + " TEXT " +
                    ")";


    public ContactsDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    // This will automatically called by the Android SDK
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create database table
        sqLiteDatabase.execSQL(TABLE_CREATE);
        Log.v(LOGCAT, "Table has been created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(sqLiteDatabase);
    }
}
