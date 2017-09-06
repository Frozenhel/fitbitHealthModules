package com.anext.fitbitmodule.model;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jiri on 19/07/17.
 */

public class AccessInfo {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires_in")
    private int expiresIn;

    @SerializedName("user_id")
    private String userId;

    List<String> scopes;

    public AccessInfo(){
        accessToken = "";
        userId = "";
    }

    public AccessInfo(String accessToken, int expiresIn, String userId) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.userId = userId;
    }

    public AccessInfo(Uri uri){
        String str = uri.toString();
        str = str.replace("mytestapp://callback#", "www.test.com/?");
        str = str.replaceAll("\\+", "%20");
        uri = Uri.parse(str);

        accessToken = uri.getQueryParameter("access_token");
        userId = uri.getQueryParameter("user_id");
        scopes = uri.getQueryParameters("scope");

    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getUserId() {
        return userId;
    }
}
