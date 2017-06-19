package com.example.lili.liliapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lili.liliapp.Model.Auctions;
import com.example.lili.liliapp.Model.Item;
import com.example.lili.liliapp.R;

import java.util.List;

/**
 * Created by Lili on 5/24/2017.
 */

public class AuctionsListAdapter extends ArrayAdapter<Auctions>{
    public AuctionsListAdapter(Context c, int resource, List<Auctions> listAuctions) {
        super(c,resource, listAuctions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null){
            LayoutInflater l = LayoutInflater.from(getContext());
        v= l.inflate(R.layout.auctions_item_list,null);

    }

    Auctions a = getItem(position);
    TextView tvStartDate = (TextView) v.findViewById(R.id.startDate);
        tvStartDate.setText(a.getStartDate().toString());

    TextView tvUser = (TextView) v.findViewById(R.id.user);
        tvUser.setText(a.getUser().getName());

        TextView tvStartPrice = (TextView) v.findViewById(R.id.startPrice);
        tvStartPrice.setText(Double.toString(a.getStartPrice()));

        return v;
    }
}
