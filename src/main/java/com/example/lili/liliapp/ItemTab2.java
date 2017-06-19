package com.example.lili.liliapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lili.liliapp.Adapters.BidAdapter;
import com.example.lili.liliapp.Model.Auctions;
import com.example.lili.liliapp.Model.Bid;
import com.example.lili.liliapp.Model.Item;
import com.example.lili.liliapp.Model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemTab2 extends Fragment {

    private static final int REQUEST_CODE = 7;

    private User u;
    List<Bid> lb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_tab2, container, false);


        FloatingActionButton bidButton = (FloatingActionButton) rootView.findViewById(R.id.bidActButton);
        bidButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBid();
            }

        });


        ListView lv = (ListView) rootView.findViewById(R.id.fiTab2);
        u = new User("Lili",1,"blabla@gmail.com","hehe","picture","address","phone");
        Item i = new Item(01,"Earings","silver","/drawable/...");
        Auctions a= new Auctions(01,256,new Date(),new Date(), u, i);
        Bid b1= new Bid(01,500, new Date(), a, u);
        Bid b2 = new Bid(02,350,new Date(),a,u);
        Bid b3= new Bid(03,650,new Date(), a,u);

        lb = new ArrayList<Bid>();
        lb.add(b1);
        lb.add(b2);
        lb.add(b3);

        BidAdapter ba = new BidAdapter(getActivity(),R.layout.bid_list, lb);
        lv.setAdapter(ba);
        return rootView;
    }
    private void startBid() {
        Intent i = new Intent(getActivity(),BidActivity.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(REQUEST_CODE == requestCode) {
            if(Activity.RESULT_OK == resultCode) {
                final int price = Integer.parseInt(data.getStringExtra("jednoznacnistring"));
                Bid bp= new Bid(01,price,new Date(),null,u);
                lb.add(bp);
                boolean isGreater=true;
                for(int i = 0; i < lb.size();i++)
                {
                    if(lb.get(i).getPrice()> price) {
                        isGreater = false;
                        break;
                    }
                }
                if(isGreater) {
                    Toast.makeText(getActivity(), "Dali ste najbolju ponudu", Toast.LENGTH_LONG).show();
                    //URADI DA VRATI PORUKICU TJ NOTIFIKACIJU
                }
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}
