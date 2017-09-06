package com.anext.ihealthmodule.model;

import android.net.Uri;

import com.anext.ihealthmodule.enums.OpenApis;

/**
 * Created by Jiri on 03/08/17.
 */

public class AccessInfo {
    private String CLIENT_ID = "348886031f2540c3952cddf41cac18f1";
    private String CLIENT_SECRET = "b32bc4d2f0354e158d1c094964949369";

    private String APIName;
    private String AccessToken;
    private int Expires;
    private String RefreshToken;
    private String UserID;
    private String client_para;

    public AccessInfo(){
    }

    public AccessInfo(String APIName, String accessToken, int expires, String refreshToken, String userID, String client_para) {
        this.APIName = APIName;
        AccessToken = accessToken;
        Expires = expires;
        RefreshToken = refreshToken;
        UserID = userID;
        this.client_para = client_para;
    }

    public String getAPIName() {
        return APIName;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public int getExpires() {
        return Expires;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public String getUserID() {
        return UserID;
    }

    public String getClient_para() {
        return client_para;
    }

    public String getClientID(){
        return CLIENT_ID;
    }

    public String getClientSecret(){
        return CLIENT_SECRET;
    }

    @Override
    public String toString() {
        return "AuthorizationResponse{" +
                "APIName='" + APIName + '\'' +
                ", AccessToken='" + AccessToken + '\'' +
                ", Expires=" + Expires +
                ", RefreshToken='" + RefreshToken + '\'' +
                ", UserID='" + UserID + '\'' +
                ", client_para='" + client_para + '\'' +
                '}';
    }
}
