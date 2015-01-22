package com.mycheapparis.app.model;

import java.util.Date;

/**
 * Created by betezed on 11/24/14.
 */
public class LocationEntry {
    private double mLatitude;
    private double mLongitude;
    private Date mDate;

    public LocationEntry(double latitude, double longitude, Date date) {
        mLatitude = latitude;
        mLongitude = longitude;
        mDate = date;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(float latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(float longitude) {
        mLongitude = longitude;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
