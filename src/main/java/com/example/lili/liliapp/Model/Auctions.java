package com.example.lili.liliapp.Model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Lili on 5/24/2017.
 */

@DatabaseTable(tableName = "auction")
public class Auctions implements Serializable{
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private double startPrice;
    @DatabaseField
    private Date startDate;
    @DatabaseField
    private Date endDate;
    @DatabaseField(foreign = true,dataType = DataType.SERIALIZABLE)
    private User user;
    @DatabaseField(foreign = true,dataType = DataType.SERIALIZABLE)
    private Item item;
    @ForeignCollectionField(eager = true) //eager(odmah,zauzima dosta memorije) ili lazy(tek kad se formira)
    private ForeignCollection<Bid> bidList;

    public Auctions(){}

    public Auctions(long id, double startPrice, Date startDate, Date endDate, User user, Item item) {
        this.id = id;
        this.startPrice = startPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user= user;
        this.item= item;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
