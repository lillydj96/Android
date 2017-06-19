package com.example.lili.liliapp.Model;

import android.widget.ListView;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lili on 5/24/2017.
 */
@DatabaseTable(tableName = "user")
public class User implements Serializable{
    @DatabaseField
    private String name;
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String email;
    @DatabaseField
    private String password;
    @DatabaseField
    private String picture;
    @DatabaseField
    private String address;
    @DatabaseField
    private String phone;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Auctions> auctionList;
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Bid> bidList;

    public User(){}

    public User(String name, long id, String email, String password, String picture, String address, String phone) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.address = address;
        this.phone = phone;
        //this.auctionList =auctionList;
       // this.bidList = bidList;
    }

    public ForeignCollection<Auctions> getAuctionList() {
        return auctionList;
    }

    public void setAuctionList(ForeignCollection<Auctions> auctionList) {
        this.auctionList = auctionList;
    }

    public ForeignCollection<Bid> getBidList() {
        return bidList;
    }

    public void setBidList(ForeignCollection<Bid> bidList) {
        this.bidList = bidList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
