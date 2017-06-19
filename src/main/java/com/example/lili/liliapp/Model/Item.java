package com.example.lili.liliapp.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Lili on 5/24/2017.
 */
@DatabaseTable(tableName = "item")
public class Item implements Serializable {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String description;
    @DatabaseField
    private String picture;
    @DatabaseField
    private boolean sold;
    @ForeignCollectionField(eager = true)
    private Collection<Auctions>auctions;

    public Item(){}

    public Item(long id, String name, String description,String picture) {
        this.id = id;
        this.name= name;
        this.description = description;
        this.picture= picture;
        this.sold =false;
    }

    public Collection<Auctions> getAuctions() {
        return auctions;
    }

    public void setAuctions(Collection<Auctions> auctions) {
        this.auctions = auctions;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isSold() {
        return sold;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
