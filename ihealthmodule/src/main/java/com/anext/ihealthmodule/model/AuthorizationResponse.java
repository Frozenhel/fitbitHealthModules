package com.anext.ihealthmodule.model;

/**
 * Created by Jiri on 04/08/17.
 */

public class AuthorizationResponse {
    private String APIName;
    private String AccessToken;
    private int Expires;
    private String RefreshToken;
    private String UserID;
    private String client_para;

    public AuthorizationResponse(String APIName, String accessToken, int expires, String refreshToken, String userID, String client_para) {
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
