package com.mycheapparis.app.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycheapparis.app.adapter.HotspotAdapter;

/**
 * Created by betezed on 11/24/14.
 */
public class Hotspot extends Location {
    public Hotspot() {}

    public Hotspot(String name, LocationEntry location, Address address) {
        this.setName(name);
        this.setLocationEntry(location);
        this.setAddress(address);
    }

    private static Hotspot sInstance;
    public static Hotspot getInstance() {
        if (sInstance == null) {
            sInstance = new Hotspot();
        }
        return sInstance;
    }

    @Override
    public Location[] parseLocations(String json) {
        Location[] locations;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Hotspot.class, new HotspotAdapter());
        Gson gson = gsonBuilder.create();
        locations = gson.fromJson(json, Hotspot[].class);
        return locations;
    }
}
