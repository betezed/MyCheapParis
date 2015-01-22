package com.mycheapparis.app.model;


/**
 * Created by betezed on 11/24/14.
 */
public abstract class Location {
    /*
     * Location est un point d'intérêt de la carte, qui doit être d'un type défini, capable de parser un json de ce type.
     */
    private LocationEntry mLocationEntry;
    private Address mAddress;
    private String mName;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address address) {
        mAddress = address;
    }

    public LocationEntry getLocationEntry() {
        return mLocationEntry;
    }

    public void setLocationEntry(LocationEntry locationEntry) {
        mLocationEntry = locationEntry;
    }

    public abstract Location[] parseLocations (String json);

    public double getDistance(LocationEntry locationEntry) {
        return Math.hypot(Math.abs(mLocationEntry.getLatitude() - locationEntry.getLatitude()), Math.abs(mLocationEntry.getLongitude() - locationEntry.getLongitude()));
    }
}
