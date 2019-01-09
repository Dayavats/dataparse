package daya.dataparse;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String JSON_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GetJson(View view) {
       new BackgroundTask().execute();
    }

    public void ParseJson(View view) {
        if(JSON_String==null){
            Toast.makeText(getApplicationContext(),"First get JSON",Toast.LENGTH_LONG).show();
        }
        else {
            Intent i=new Intent(this,DisplayListView.class);
            i.putExtra("json_data",JSON_String);
            startActivity(i);
        }
    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String JSON_Url;
        @Override
        protected void onPreExecute() {
            JSON_Url="http://nklearnicare.herokuapp.com/api/eventsatglance";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(JSON_Url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSON_String = bufferedReader.readLine()) != null) {
                    stringBuilder.append(JSON_String + '\n');
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView=findViewById(R.id.t1);
            textView.setText(result);
            JSON_String=result;
        }
    }

}