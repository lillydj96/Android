package com.example.lili.liliapp.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.lili.liliapp.AuctionActivity;
import com.example.lili.liliapp.Model.Auctions;
import com.example.lili.liliapp.Model.Bid;
import com.example.lili.liliapp.Model.Item;
import com.example.lili.liliapp.Model.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Lili on 6/9/2017.
 */

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "LiliDataBase";
    private static final int DATABASE_VERSION = 7;

    private RuntimeExceptionDao<Auctions, String> auctionDAO = null;
    private RuntimeExceptionDao<Bid, String> bidDAO = null;
    private RuntimeExceptionDao<Item, String>itemDAO = null;
    private RuntimeExceptionDao<User, String>userDAO = null;

    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource,Auctions.class);
            TableUtils.createTable(connectionSource,Bid.class);
            TableUtils.createTable(connectionSource,Item.class);
            TableUtils.createTable(connectionSource,User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//Connection source-gde se baza nalazi,..i ostali podaci kako bi mogao da je pronadje
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

        try {
            TableUtils.dropTable(connectionSource,Auctions.class,true);
            TableUtils.dropTable(connectionSource,Bid.class,true);
            TableUtils.dropTable(connectionSource,Item.class,true);
            TableUtils.dropTable(connectionSource,User.class,true);
            onCreate(sqLiteDatabase,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Context getContext() {
        return context;
    }

    public RuntimeExceptionDao<Auctions, String> getAuctionDAO() {
        if(auctionDAO ==null) {
            auctionDAO = getRuntimeExceptionDao(Auctions.class);
        }
        return auctionDAO;
    }

    public RuntimeExceptionDao<Bid, String> getBidDAO() {
        if(bidDAO == null){
            bidDAO= getRuntimeExceptionDao(Bid.class);
        }
        return bidDAO;
    }

    public RuntimeExceptionDao<Item, String> getItemDAO() {
        if(itemDAO == null){
            itemDAO= getRuntimeExceptionDao(Item.class);
        }
        return itemDAO;
    }

    public RuntimeExceptionDao<User, String> getUserDAO() {
        if(userDAO == null){
            userDAO= getRuntimeExceptionDao(User.class);
        }
        return userDAO;
    }
}
