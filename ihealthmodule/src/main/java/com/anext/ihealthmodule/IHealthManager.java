package com.anext.ihealthmodule;

import android.net.Uri;
import android.util.Log;

import com.anext.ihealthmodule.exception.HttpCodeException;
import com.anext.ihealthmodule.manager.DataManager;
import com.anext.ihealthmodule.model.AccessInfo;
import com.anext.ihealthmodule.service.DataServices;
import com.anext.ihealthmodule.service.AuthenticationService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jiri on 02/08/17.
 */

public class IHealthManager {
    private static final String CLIENT_ID = "348886031f2540c3952cddf41cac18f1";
    public static final String CALLBACK_URL = "mytestapp://ihealthcallback/";

    private static IHealthManager instance;

    private Retrofit retrofit;
    private DataManager dataManager;
    private AuthenticationService authenticationService;

    private AccessInfo accessInfo;
    private Uri authenticationUrl;

    private IHealthManager(){
        authenticationUrl = generateAuthenticationUrl();
        accessInfo = new AccessInfo();
    }

    public static IHealthManager getInstance(){
        if(instance == null)
            instance = new IHealthManager();
        return instance;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public Uri getAuthenticationUrl(){
        return authenticationUrl;
    }

    private Uri generateAuthenticationUrl(){
        String url = "http://sandboxapi.ihealthlabs.com/OpenApiV2/OAuthv2/userauthorization/" +
                "?client_id=" + CLIENT_ID +
                "&response_type=code" +
                "&redirect_uri=mytestapp://iHealthCallback" +
                "&APIName=OpenApiActivity OpenApiBG OpenApiBP OpenApiSleep OpenApiSpO2 OpenApiUserInfo OpenApiWeight";

        return Uri.parse(url);
    }

    public void authenticate(Uri uri){
        String code = uri.getQueryParameter("code");
        createRetrofitServices();
        authenticate(code);
    }

    private void createRetrofitServices(){
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient().newBuilder();
        okHttpBuilder.addInterceptor(new Interceptor() {
            @Override public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().build();
                return chain.proceed(request);
            }
        });

        OkHttpClient okHttpClient = okHttpBuilder.build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://sandboxapi.ihealthlabs.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();
        authenticationService = retrofit.create(AuthenticationService.class);
    }

    private void authenticate(String code){
        Call<AccessInfo> call  = authenticationService.getAccessToken(accessInfo.getClientID(),accessInfo.getClientSecret(), "authorization_code","http://mytestapp.com/healthcallback", code);
        call.enqueue(new Callback<AccessInfo>() {
            @Override
            public void onResponse(Call<AccessInfo> call, Response<AccessInfo> response) {
                Log.d("AUHTENTICATE", "onResponse");
                accessInfo = response.body();

                DataServices service = retrofit.create(DataServices.class);
                dataManager = new DataManager(service,accessInfo);
            }

            @Override
            public void onFailure(Call<AccessInfo> call, Throwable t) {
                Log.d("AUHTENTICATE", "onFailure");
            }
        });
    }

    public static void validateResponseCode(@NotNull Response response) throws HttpCodeException, IOException {
        if(response.code() != 200 && response.code() != 201){
            throw new HttpCodeException(response.code(), response.errorBody().string());
        }
    }
}
