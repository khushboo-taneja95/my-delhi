package com.letsdowebsite.mydelhi;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class MyPreferences {
    private static MyPreferences preferences = null;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor editor;
    private String flag = "flag";
    private String isLogedIn = "isLogedIn";
    private String userId = "userId";
    private String emailId = "emailId";
    private String firstName = "firstName";
    private String userName = "userName";
    private String lastName = "lastName";
    private String mobileNo = "mobileNo";
    private String mobileNo1 = "mobileNo";
    private String bookingId = "bookingId";
    private String image = "image";
    private String facebookimage = "facebookimage";
    private String Language = "language";
    private String LanguageOnetime = "LanguageOnetime";


    public MyPreferences(Context context) {
        setmPreferences(PreferenceManager.getDefaultSharedPreferences(context));
    }


    public SharedPreferences getmPreferences() {
        return mPreferences;
    }

    public void setmPreferences(SharedPreferences mPreferences) {
        this.mPreferences = mPreferences;
    }


    public static MyPreferences getActiveInstance(Context context) {
        if (preferences == null) {
            preferences = new MyPreferences(context);
        }
        return preferences;
    }

    public boolean getIsLoggedIn() {
        return mPreferences.getBoolean(this.isLogedIn, false);
    }

    public void setIsLoggedIn(boolean isLoggedin) {
        editor = mPreferences.edit();
        editor.putBoolean(this.isLogedIn, isLoggedin);
        editor.commit();
    }

    public boolean getLanguageOnetime() {
        return mPreferences.getBoolean(this.LanguageOnetime, false);
    }

    public void setLanguageOnetime(boolean LanguageOnetime) {
        editor = mPreferences.edit();
        editor.putBoolean(this.LanguageOnetime, LanguageOnetime);
        editor.commit();
    }

    public boolean getflag() {
        return mPreferences.getBoolean(this.flag, false);
    }

    public void setflag(boolean flag) {
        editor = mPreferences.edit();
        editor.putBoolean(this.flag, flag);
        editor.commit();
    }


    public String getUserId() {
        return mPreferences.getString(this.userId, "");

    }


    public void setUserId(String userId) {
        editor = mPreferences.edit();
        editor.putString(this.userId, userId);
        editor.commit();
    }
    public String getEmailId() {
        return mPreferences.getString(this.emailId, "");

    }


    public void setEmailId(String emailId) {
        editor = mPreferences.edit();
        editor.putString(this.emailId, emailId);
        editor.commit();
    }


    public void setFirstName(String firstName) {
        editor = mPreferences.edit();
        editor.putString(this.firstName, firstName);
        editor.commit();
    }

    public String getFirstName() {
        return mPreferences.getString(this.firstName, "");
    }
    public void setuserName(String userName) {
        editor = mPreferences.edit();
        editor.putString(this.userName, userName);
        editor.commit();
    }

    public String getuserName() {
        return mPreferences.getString(this.userName, "");
    }
    public String getLastName() {
        return mPreferences.getString(this.lastName, "");
    }

    public void setLastName(String lastName) {
        editor = mPreferences.edit();
        editor.putString(this.lastName, lastName);
        editor.commit();
    }
    public String getbookingId() {
        return mPreferences.getString(this.bookingId, "");
    }

    public void setbookingId(String bookingId) {
        editor = mPreferences.edit();
        editor.putString(this.bookingId, bookingId);
        editor.commit();
    }
    public String getimage() {
        return mPreferences.getString(this.image, "");
    }

    public void setimage(String image) {
        editor = mPreferences.edit();
        editor.putString(this.image, image);
        editor.commit();
    }
    public String getfacebookimage() {
        return mPreferences.getString(this.facebookimage, "");
    }

    public void setfacebookimage(String facebookimage) {
        editor = mPreferences.edit();
        editor.putString(this.facebookimage, facebookimage);
        editor.commit();
    }

    public String getLanguage() {
        return mPreferences.getString(this.Language, "");
    }

    public void setLanguage(String Language) {
        editor = mPreferences.edit();
        editor.putString(this.Language, Language);
        editor.commit();
    }

    public String getMobileNo() {
        return mPreferences.getString(this.mobileNo, "");
    }

    public void setMobileNo(String mobileNo) {
        editor = mPreferences.edit();
        editor.putString(this.mobileNo, mobileNo);
        editor.commit();
    }
    public String getMobileNo1() {
        return mPreferences.getString(this.mobileNo1, "");
    }

    public void setMobileNo1(String mobileNo1) {
        editor = mPreferences.edit();
        editor.putString(this.mobileNo1, mobileNo1);
        editor.commit();
    }


}
