package com.m.govfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 01-Mar-18.
 */

public class FileAdapter extends BaseAdapter {

    ArrayList<Files> arrayList;
    Context context;
    private static LayoutInflater inflater=null;
    FileAdapter(Context context,ArrayList<Files> arrayList)
    {
        this.arrayList=arrayList;
        this.context=context;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView = inflater.inflate(R.layout.file_item, null);
        TextView filename=(TextView)rowView.findViewById(R.id.file_name);
        TextView filedesc=(TextView)rowView.findViewById(R.id.desc);
        TextView filestatus=(TextView)rowView.findViewById(R.id.status);

        filename.setText(arrayList.get(position).file_name);
        filedesc.setText(arrayList.get(position).file_desc);
        filestatus.setText(arrayList.get(position).file_status);

        return rowView;
    }
}
