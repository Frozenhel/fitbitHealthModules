package com.anext.ihealthmodule.service;

import com.anext.ihealthmodule.model.AccessInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Jiri on 04/08/17.
 */

public interface AuthenticationService {
    @GET("OpenApiV2/OAuthv2/userauthorization/")
    Call<AccessInfo> getAccessToken(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("grant_type") String authorizationCode,
            @Query("redirect_uri") String redirect_uri,
            @Query("code") String code
    );

}
