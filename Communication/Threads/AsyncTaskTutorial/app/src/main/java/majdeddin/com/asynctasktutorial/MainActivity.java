package majdeddin.com.asynctasktutorial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.TextView01);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void onClick(View view) {
        DownloadWebPageTask task = new DownloadWebPageTask();
        task.execute(new String[]{"http://www.google.com"});

    }

    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {
            String response = "";
            for (String url : urls) {
                DefaultHttpClient client = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(url);
                try {
                    HttpResponse execute = client.execute(httpGet);
                    InputStream content = execute.getEntity().getContent();

                    BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                    String s = "";
                    while ((s = buffer.readLine()) != null) {
                        response += s;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
        }


    }




}

