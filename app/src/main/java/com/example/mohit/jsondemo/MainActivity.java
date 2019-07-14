package com.example.mohit.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView txtdata;
    String jsonstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtdata = findViewById(R.id.textView);
    }

    public void clkcjson(View view) {
        try {
            //first step is creation of objects
            JSONObject jobj1 = new JSONObject();
            jobj1.put("id" , 101);
            jobj1.put("name", "Mohit");
            jobj1.put("salary",60000);

            JSONObject jobj2 = new JSONObject();
            jobj2.put("id", 102);
            jobj2.put("name","Jatin");
            jobj2.put("salary",50000);

            //now second step is we put these object in array
            JSONArray jarr = new JSONArray();
            jarr.put(jobj1);
            jarr.put(jobj2);

            //now we will show that array as an complete object
            //outer object will take whole array
            JSONObject jobj = new JSONObject();
            jobj.put("Employee",jarr);

            jsonstring = jobj.toString();
            txtdata.setText(jsonstring);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void clkpjson(View view) {
        try {
            JSONObject jsonObject = new JSONObject(jsonstring);
            JSONArray jsonArray = jsonObject.getJSONArray("Employee");
            //now to retrieve data from array we use StringBuffer class
            StringBuffer strbuff = new StringBuffer();
            for(int i=0;i<jsonArray.length();i++){
                jsonObject = (JSONObject) jsonArray.get(i);
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                int salary = jsonObject.getInt("salary");

                strbuff.append(id+" "+name+" "+salary+"\n");
            }
            txtdata.setText(strbuff.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
