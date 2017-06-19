package com.example.lili.liliapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lili.liliapp.Model.Bid;
import com.example.lili.liliapp.Model.User;
import com.example.lili.liliapp.R;

import org.w3c.dom.NameList;
import org.w3c.dom.Text;

import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Lili on 6/5/2017.
 */

public class BidAdapter extends ArrayAdapter<Bid> {
    public BidAdapter(Context c, int resource, List<Bid> listBid) {
        super(c, resource, listBid);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater l = LayoutInflater.from(getContext());
            v = l.inflate(R.layout.bid_list, null);
        }

        Bid b = getItem(position);
        TextView user = (TextView) v.findViewById(R.id.user);
        user.setText(b.user.getName().toString());

        TextView dateTime = (TextView) v.findViewById(R.id.dateTime);
        dateTime.setText(b.getDateTime().toString());

        TextView priceBid = (TextView) v.findViewById(R.id.priceBid);
        priceBid.setText(Double.toString(b.getPrice()));


        return v;
    }
}
