package com.mycheapparis.app.model;

/**
 * Created by betezed on 11/24/14.
 */
public class User {
    private String mLogin;
    private String mPassword;
    private Profile mProfile;

    public String getmLogin() {
        return mLogin;
    }

    public void setmLogin(String mLogin) {
        this.mLogin = mLogin;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}