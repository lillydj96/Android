package com.example.lili.liliapp;

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

import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lili.liliapp.Adapters.AuctionsListAdapter;
import com.example.lili.liliapp.Model.Auctions;
import com.example.lili.liliapp.Model.Item;
import com.example.lili.liliapp.Model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemTab1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_tab1, container, false);

        ListView lv = (ListView) rootView.findViewById(R.id.fiTab1);
        User u = new User("Lili",1,"blabla@gmail.com","hehe","picture","address","phone");
        Auctions a1 = new Auctions(01,250, new Date(),new Date(), u, new Item());
        Auctions a2 = new Auctions(2,350, new Date(),new Date(), u, new Item());
        Auctions a3 = new Auctions(3,450, new Date(),new Date(), u, new Item());
        List<Auctions> au = new ArrayList<Auctions>() ;
        au.add(a1);
        au.add(a2);
        au.add(a3);
        AuctionsListAdapter alA = new AuctionsListAdapter(getActivity(),R.layout.auctions_item_list,au);
        lv.setAdapter(alA);
        return rootView;

    }

}