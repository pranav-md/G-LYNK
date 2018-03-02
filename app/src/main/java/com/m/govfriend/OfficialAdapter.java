package com.m.govfriend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 02-Mar-18.
 */

public class OfficialAdapter extends BaseAdapter {

    ArrayList<Officials> arrayList;
    Context context;
    private static LayoutInflater inflater=null;
    OfficialAdapter(Context context,ArrayList<Officials> arrayList)
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
        View rowView = inflater.inflate(R.layout.official_list, null);
        TextView filename=(TextView)rowView.findViewById(R.id.off_name);
        CircleImageView dp=(CircleImageView)rowView.findViewById(R.id.dp);
        filename.setText(arrayList.get(position).name);
        int resID = context.getResources().getIdentifier(arrayList.get(position).dp
                ,"drawable", "com.m.govfriend");
        dp.setImageResource(resID );
        return rowView;
    }
}
