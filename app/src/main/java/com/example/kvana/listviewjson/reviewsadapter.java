package com.example.kvana.listviewjson;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kvana on 5/10/17.
 */

public class reviewsadapter extends ArrayAdapter<reviews>{
    private ArrayList<reviews> reviewList;
    private LayoutInflater vi;
    private int Resource;
    private ViewHolder holder;



    reviewsadapter(Context context, int resource, ArrayList<reviews> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        this.reviewList = objects;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);


            holder.tvid = (TextView) v.findViewById(R.id.tv_id);
            holder.tvname = (TextView) v.findViewById(R.id.tv_name);
            holder.tveamil = (TextView) v.findViewById(R.id.tv_eamil);
            holder.tvphone = (TextView) v.findViewById(R.id.tv_phone);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.tvid.setText(reviewList.get(position).getId());
        holder.tvname.setText(reviewList.get(position).getName());
        holder.tveamil.setText(reviewList.get(position).getEmail());
        holder.tvphone.setText(reviewList.get(position).getPhone());


        return v;

    }

    private static class ViewHolder {

       // TextView id;
        //TextView name;
        //TextView email;
        //TextView mobile;
        public TextView tvid;
        public TextView tvname;
        public TextView tveamil;
        public TextView tvphone;
    }

}
