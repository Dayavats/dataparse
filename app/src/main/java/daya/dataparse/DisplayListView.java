package daya.dataparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    String JSON_String;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdaptor contactAdaptor;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);
        listView=findViewById(R.id.listview);
        contactAdaptor=new ContactAdaptor(this,R.layout.raw_layout);
        listView.setAdapter(contactAdaptor);


        JSON_String=getIntent().getExtras().getString("json_data");
        try {
            jsonObject=new JSONObject(JSON_String);
            jsonArray=jsonObject.getJSONArray("topics");
            int count=0;
            String id,type,topic,_v;
            while (count<jsonArray.length()){
                JSONObject JO=jsonArray.getJSONObject(count);
                id= JO.getString("_id");
                topic=JO.getString("topic");
                type=JO.getString("type");
                _v=JO.getString("__v");
                Contacts contacts=new Contacts(id,topic,type,_v);
                contactAdaptor.add(contacts);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
