package daya.dataparse;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdaptor extends ArrayAdapter {
    List list=new ArrayList();
    public ContactAdaptor( Context context, int resource) {
        super(context, resource);
    }


    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View row;
        row=convertView;
        ContactHolder contactHolder;
        if(row==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.raw_layout,parent,false);
            contactHolder=new ContactHolder();
            contactHolder._id=row.findViewById(R.id._id);
            contactHolder.txtopic = row.findViewById(R.id.txtopic);
            contactHolder.txtype=row.findViewById(R.id.txtype);
            contactHolder.tx_v=row.findViewById(R.id.tx_v);
            row.setTag(contactHolder);


        }
        else

        {
            contactHolder= (ContactHolder) row.getTag();;
        }
        Contacts contacts= (Contacts) this.getItem(position);
        contactHolder._id.setText(contacts.getId());
        contactHolder.txtopic.setText(contacts.getTopic());
        contactHolder.txtype.setText(contacts.getType());
        contactHolder.tx_v.setText(contacts.get_v());


        
        return row;
    }
    static class ContactHolder {
        TextView _id, txtopic, txtype, tx_v;

    }
}