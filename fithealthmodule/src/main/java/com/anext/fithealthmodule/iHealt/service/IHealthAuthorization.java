package com.anext.fithealthmodule.iHealt.service;

import com.anext.fithealthmodule.iHealt.model.AccessToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Jiri on 19/07/17.
 */

public interface IHealthAuthorization {

    @POST("OpenApiV2/OAuthv2/userauthorization")
    @FormUrlEncoded
    Call<AccessToken> getAccessToken(
            @Field("client_id") String clientId,
            @Field("response_type") String responseType,
            @Field("redirect_uri") String redirectUri,
            @Field("APIName") String APIName,
            @Field("RequiredAPIName") String requiredAPIName,
            @Field("IsNew") String isNew
    );



}
