package com.example.lili.liliapp.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lili.liliapp.Model.Item;
import com.example.lili.liliapp.R;

import java.util.List;

/**
 * Created by Lili on 5/24/2017.
 */

public class ItemsListAdapter extends ArrayAdapter<Item>{
    public ItemsListAdapter(Context c, int resource, List<Item> items) {
        super(c,resource,items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if(v == null) {
            LayoutInflater l = LayoutInflater.from(getContext());
            v= l.inflate(R.layout.item_list_view,null);

        }

        Item i = getItem(position);
        TextView tvName = (TextView) v.findViewById(R.id.lviName);
        tvName.setText(i.getName());

        TextView tvDescription = (TextView) v.findViewById(R.id.lviDescription);
        tvDescription.setText(i.getDescription());

        return v;

    }

}