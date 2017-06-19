package com.example.lili.liliapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.lili.liliapp.Adapters.ItemsListAdapter;
import com.example.lili.liliapp.Helpers.DataBaseHelper;
import com.example.lili.liliapp.Model.Auctions;
import com.example.lili.liliapp.Model.Bid;
import com.example.lili.liliapp.Model.Item;
import com.example.lili.liliapp.Model.User;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionBtutton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        Button startItem= (Button) findViewById(R.id.ItemButton);
        startItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Item item1 = new Item(01,"Ring","moon","ddglagn");
        Item item2 = new Item(02,"Earrings","silver","hfadgh");
        Item item3 = new Item(03,"Necklace","silver","jafh");

        //pozivam bazu i kreiram novu za item
        DataBaseHelper helper = new DataBaseHelper(this);
        RuntimeExceptionDao<Item, String> itemDAOl = helper.getItemDAO();
      //  itemDAOl.create(item1);
       // itemDAOl.create(item2);
        //itemDAOl.create(item3);


         itemList= itemDAOl.queryForAll();
        //itemList.add(item1);
        //itemList.add(item2);
        //itemList.add(item3);

        User u = new User("Lili",01,"fahjfa","hadfja","gadjhga","afhakf","jhfda");

        RuntimeExceptionDao<User, String > userDAOl = helper.getUserDAO();
        userDAOl.create(u);

        List<User> userList = userDAOl.queryForAll();


        RuntimeExceptionDao<Auctions, String> auctionsDAOl = helper.getAuctionDAO();
        Auctions a1 = new Auctions(01,250, new Date(),new Date(), u, item1);
        Auctions a2 = new Auctions(2,350, new Date(),new Date(), u, item2);
        Auctions a3 = new Auctions(3,450, new Date(),new Date(), u, item3);

        auctionsDAOl.create(a1);
        auctionsDAOl.create(a2);
        auctionsDAOl.create(a3);

        List<Auctions> auctionsList = auctionsDAOl.queryForAll();

        RuntimeExceptionDao<Bid, String> bidDAOl = helper.getBidDAO();
        Bid b1 = new Bid(01,256,new Date(),a1,u);
        Bid b2 = new Bid(02,659,new Date(),a2,u);
        Bid b3 = new Bid(03,123,new Date(),a3,u);
        bidDAOl.create(b1);
        bidDAOl.create(b2);
        bidDAOl.create(b3);

        List<Bid> bidList = bidDAOl.queryForAll();

        ItemsListAdapter ilAdapter = new ItemsListAdapter(this,R.layout.item_list_view,itemList);
        ListView lv = (ListView) findViewById(R.id.lvItems);
        lv.setAdapter(ilAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startItemActivity(position);
            }


        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void startItemActivity(int position) {
        Item i = itemList.get(position);
        Intent in = new Intent(this,ItemActivity.class);
        in.putExtra("itemId",i.getId());
        startActivity(in);
    }
    //dohvati id itema i prenese


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
