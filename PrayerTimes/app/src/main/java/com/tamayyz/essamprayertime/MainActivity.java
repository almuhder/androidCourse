package com.tamayyz.essamprayertime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ListView list;
    ArrayList<String> dataList = new ArrayList<>();
    TextView tv;
    String[] x1 = {"s", "s", "d"};

    String url = "http://api.islamhouse.com/v1/9AdcUE1UplL3DZfW/services/praytime/get-times/Makkah/30.0599153/31.2620199/+3/json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        tv = (TextView) findViewById(R.id.textView);


        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest x = new JsonObjectRequest(
                Request.Method.GET, //
                url,    // the url data you want to read from
                null,   // object to be send to the url
                // the data has been received
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray timeArray = response.getJSONArray("times");
//                            Toast.makeText(MainActivity.this, timeArray.toString(), Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < timeArray.length(); i++) {
//                                Toast.makeText(MainActivity.this, timeArray.get(i).toString(), Toast.LENGTH_SHORT).show();

                                switch (i) {

                                    case 1:
                                        dataList.add(timeArray.get(i).toString() + "    " + "الفجر");
                                        break;
                                    case 2:
                                        dataList.add(timeArray.get(i).toString() + "الشروق");
                                        break;
                                    case 3:
                                        dataList.add(timeArray.get(i).toString() + "الظهر");
                                        break;
                                    case 4:
                                        dataList.add(timeArray.get(i).toString() + "العصر");
                                        break;
                                    case 5:
                                        dataList.add(timeArray.get(i).toString() + "المفرب");
                                        break;
                                    case 6:
                                        dataList.add(timeArray.get(i).toString() + "العشا");
                                        break;
                                }



//                                if (i == 0) {
//                                    dataList.add(timeArray.get(i).toString() + "    " + "الفجر");
//                                }
//                                if (i == 1) {
//                                    dataList.add(timeArray.get(i).toString() + "الشروق");
//                                }
//                                if (i == 2) {
//                                    dataList.add(timeArray.get(i).toString() + "الظهر");
//                                }
//                                if (i == 3) {
//                                    dataList.add(timeArray.get(i).toString() + "العصر");
//                                }
//                                if (i == 4) {
//                                    // dataList.add(timeArray.get(i).toString()+ "الفروب");
//                                }
//                                if (i == 5) {
//                                    dataList.add(timeArray.get(i).toString() + "المفرب");
//                                }
//                                if (i == 6) {
//                                    dataList.add(timeArray.get(i).toString() + "العشا");
//                                }


                            }

                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dataList);
                            list.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Connection error", Toast.LENGTH_SHORT).show();

                        }

                    }
                },
                null
        );


        queue.add(x);


    }
}
