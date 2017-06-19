package com.example.lili.liliapp.Model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lili on 5/25/2017.
 */
@DatabaseTable(tableName = "bid")
public class Bid implements Serializable {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    public double price;
    @DatabaseField
    public Date dateTime;
    @DatabaseField(foreign = true,dataType = DataType.SERIALIZABLE)
    public Auctions auctions;
    @DatabaseField(foreign = true,dataType = DataType.SERIALIZABLE)
    public User user;

    public Bid(){}

    public Bid(long id, double price, Date dateTime,Auctions auctions,User user)
    {
        this.id = id;
        this.price = price;
        this.dateTime = dateTime;
        this.auctions = auctions;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Auctions getAuctions() {
        return auctions;
    }

    public void setAuctions(Auctions auctions) {
        this.auctions = auctions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
