package com.mycheapparis.app.model;

/**
 * Created by betezed on 11/24/14.
 */
public class Profile {
    private int mAge;
    private Location mCurrentLocation;
    private String mLanguage;

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public Location getCurrentLocation() {
        return mCurrentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        mCurrentLocation = currentLocation;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}

