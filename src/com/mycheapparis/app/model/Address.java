package com.mycheapparis.app.model;


import org.apache.commons.lang.StringEscapeUtils;

/**
 * Created by betezed on 11/24/14.
 */
public class Address {
    private String mNumStreet;
    private String mZipCode;
    private String mCity;

    public Address(String numStreet,String zipCode, String city) {
        mNumStreet = numStreet;
        mZipCode = zipCode;
        mCity = city;
    }

    public String getNumStreet() {
        return mNumStreet;
    }

    public void setNumStreet(String numStreet) {
        mNumStreet = numStreet;
    }
    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String zipCode) {
        mZipCode = zipCode;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    @Override
    public String toString() {
        return StringEscapeUtils.escapeJavaScript(mNumStreet + ", " + mZipCode + " " + mCity);
    }
}
