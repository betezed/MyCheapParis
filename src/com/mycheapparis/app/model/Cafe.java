package com.mycheapparis.app.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycheapparis.app.adapter.CafeAdapter;

/**
 * Created by betezed on 11/24/14.
 */
public class Cafe extends Location {

    private double mCafePrice;

    public Cafe() {}

    public Cafe(String name, double price, LocationEntry location, Address address) {
        this.setName(name);
        this.setLocationEntry(location);
        this.setAddress(address);
        this.setCafePrice(price);
    }

    public double getCafePrice() {
        return mCafePrice;
    }

    public void setCafePrice(double cafePrice) {
        mCafePrice = cafePrice;
    }

    private static Cafe sInstance;
    public static Cafe getInstance() {
        if (sInstance == null) {
            sInstance = new Cafe();
        }
        return sInstance;
    }

    @Override
    public Location[] parseLocations(String json) {
        Location[] locations;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Cafe.class, new CafeAdapter());
        Gson gson = gsonBuilder.create();
        locations = gson.fromJson(json, Cafe[].class);
        return locations;
    }
}
