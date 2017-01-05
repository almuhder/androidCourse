package majdeddin.com.testsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this, "Users", null , 1 );
        //dbHelper.addUser();
       // dbHelper.addUser("Ahmad","ali");
        dbHelper.addUser("Ayman","MHD");
        //dbHelper.deleteUser(1);
        dbHelper.getUsersCount();

        dbHelper.showUser(5);

        dbHelper.updateUsers(5, "Obaaaaada", "OBABDA");

        dbHelper.showUser(5);


    }



    public void showAll(View v){

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }
}
