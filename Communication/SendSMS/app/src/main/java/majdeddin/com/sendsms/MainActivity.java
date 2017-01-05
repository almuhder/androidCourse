package majdeddin.com.sendsms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText phoneNumber, smsBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        smsBody = (EditText) findViewById(R.id.smsBody);
    }

    public void sendSmsByManager(View v) {

        try {
            // Get the default instance of the SmsManager
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber.getText().toString(),
                    null,
                    smsBody.getText().toString(),
                    null,
                    null);
            Toast.makeText(getApplicationContext(), "Your sms has successfully sent!", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Your sms has failed...", Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }

    }


    public void sendSmsBySIntent(View v) {

        // add the phone number in the data
        Uri uri = Uri.parse("smsto:" + phoneNumber.getText().toString());
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
        // add the message at the sms_body extra field
        smsIntent.putExtra("sms_body", smsBody.getText().toString());
        try {
            startActivity(smsIntent);
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, "Your sms has failed...", Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }

    }


    public void sendSmsByVIntent(View V) {

        Intent smsVIntent = new Intent(Intent.ACTION_VIEW);
        // prompts only sms-mms clients
        smsVIntent.setType("vnd.android-dir/mms-sms");

        // extra fields for number and message respectively
        smsVIntent.putExtra("address", phoneNumber.getText().toString());
        smsVIntent.putExtra("sms_body", smsBody.getText().toString());
        try {
            startActivity(smsVIntent);
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, "Your sms has failed...",Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }

    }
}
