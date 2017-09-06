package com.anext.ihealthmodule.manager;


import com.anext.ihealthmodule.IHealthManager;
import com.anext.ihealthmodule.enums.OpenApis;
import com.anext.ihealthmodule.exception.HttpCodeException;
import com.anext.ihealthmodule.model.AccessInfo;
import com.anext.ihealthmodule.model.Activity;
import com.anext.ihealthmodule.model.ActivityResult;
import com.anext.ihealthmodule.model.BloodPressure;
import com.anext.ihealthmodule.model.BloodPressureResult;
import com.anext.ihealthmodule.model.Glucose;
import com.anext.ihealthmodule.model.GlucoseResult;
import com.anext.ihealthmodule.model.OpenApi;
import com.anext.ihealthmodule.model.Sleep;
import com.anext.ihealthmodule.model.SleepResult;
import com.anext.ihealthmodule.model.Weight;
import com.anext.ihealthmodule.model.WeightResult;
import com.anext.ihealthmodule.service.DataServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Jiri on 02/08/17.
 */

public class DataManager {
    private Map<String, String> requiredParameters;
    private Map<String, OpenApi> apis;
    private DataServices service;
    private AccessInfo accessInfo;

    public DataManager(DataServices service, AccessInfo accessInfo){
        this.service = service;
        this.accessInfo = accessInfo;
        buildRequierdParametersMap();
        createApis();
    }

    private void createApis(){
        apis = new HashMap<>();
        String APIName = accessInfo.getAPIName();
        if(APIName.contains("OpenApiActivity"))apis.put("OpenApiActivity", new OpenApi("OpenApiActivity","082a65ac25db4262b795f635c974de47","34f4434741414722b15fbbdb3db8813e"));
        if(APIName.contains("OpenApiBG"))apis.put("OpenApiBG", new OpenApi("OpenApiBG","082a65ac25db4262b795f635c974de47","978af9615739478ea29794ea5f4c5dbe"));
        if(APIName.contains("OpenApiBP"))apis.put("OpenApiBP", new OpenApi("OpenApiBP","082a65ac25db4262b795f635c974de47","add22354420244ba9e0f3a5a6b402096"));
        if(APIName.contains("OpenApiSleep"))apis.put("OpenApiSleep", new OpenApi("OpenApiSleep","082a65ac25db4262b795f635c974de47","d7a1dfc8939742bca0a41e615b7eef3c"));
        if(APIName.contains("OpenApiSpO2"))apis.put("OpenApiSpO2", new OpenApi("OpenApiSpO2","082a65ac25db4262b795f635c974de47","3ea83f3ca05342b5b862cbcddf38f6f3"));
        if(APIName.contains("OpenApiUserInfo"))apis.put("OpenApiUserInfo", new OpenApi("OpenApiUserInfo","082a65ac25db4262b795f635c974de47","ba698f077b3843e8b2a397ab88b9e8c1"));
        if(APIName.contains("OpenApiWeight"))apis.put("OpenApiWeight", new OpenApi("OpenApiWeight","082a65ac25db4262b795f635c974de47","bd82a25dcf18446b90f3219ef7d0b441"));
    }

    private OpenApi getApi(OpenApis openApis){
        switch (openApis){
            case ACTIVITY:
                return apis.get("OpenApiActivity");
            case BLOOD_GLUCOSE:
                return apis.get("OpenApiBG");
            case BLOOD_PRESURE:
                return apis.get("OpenApiBP");
            case SLEEP:
                return apis.get("OpenApiSleep");
            case SP02:
                return apis.get("OpenApiSpO2");
            case USER_INFO:
                return apis.get("OpenApiUserInfo");
            case WEIGHT:
                return apis.get("OpenApiWeight");
            default:
                return new OpenApi("NOT_IMPLEMENTED", "", "");
        }
    }

    private void buildRequierdParametersMap(){
        requiredParameters = new HashMap<>();
        requiredParameters.put("CLIENT_ID", accessInfo.getClientID());
        requiredParameters.put("CLIENT_SECRET", accessInfo.getClientSecret());
        requiredParameters.put("ACCESS_TOKEN", accessInfo.getAccessToken());
    }

    public List<Activity> downloadActivities() throws HttpCodeException, IOException {
        List<Activity> activities = new ArrayList<>();

        Call<ActivityResult> call = service.getActivities(accessInfo.getUserID(),requiredParameters, getApi(OpenApis.ACTIVITY).getSC(), getApi(OpenApis.ACTIVITY).getSV());
        Response<ActivityResult> response = call.execute();
        IHealthManager.validateResponseCode(response);

        if(response.body()!=null){
            activities.addAll(response.body().getARDataList());
        }

        while (response.body().getNextPageUrl().length() > 0){
            call = service.getActivitiesNextPage(response.body().getNextPageUrl());
            response = call.execute();
            IHealthManager.validateResponseCode(response);

            if(response.body() != null){
                activities.addAll(response.body().getARDataList());
            }
        }

        return activities;
    }


    public List<Weight> downloadWeights() throws HttpCodeException, IOException {
        List<Weight> weights = new ArrayList<>();

        Call<WeightResult> call = service.getWeights(accessInfo.getUserID(),requiredParameters, getApi(OpenApis.ACTIVITY).getSC(), getApi(OpenApis.ACTIVITY).getSV());
        Response<WeightResult> response = call.execute();
        IHealthManager.validateResponseCode(response);

        if(response.body()!=null){
            weights.addAll(response.body().getWeightDataList());
        }

        while (response.body().getNextPageUrl().length() > 0){
            call = service.getWeightsNextPage(response.body().getNextPageUrl());
            response = call.execute();
            IHealthManager.validateResponseCode(response);

            if(response.body() != null){
                weights.addAll(response.body().getWeightDataList());
            }
        }

        return weights;
    }

    public List<Glucose> downloadGlucoses() throws HttpCodeException, IOException {
        List<Glucose> glucoses = new ArrayList<>();

        Call<GlucoseResult> call = service.getGlucoses(accessInfo.getUserID(),requiredParameters, getApi(OpenApis.ACTIVITY).getSC(), getApi(OpenApis.ACTIVITY).getSV());
        Response<GlucoseResult> response = call.execute();
        IHealthManager.validateResponseCode(response);

        if(response.body()!=null){
            glucoses.addAll(response.body().getBGDataList());
        }

        while (response.body().getNextPageUrl().length() > 0){
            call = service.getGlucosesNextPage(response.body().getNextPageUrl());
            response = call.execute();
            IHealthManager.validateResponseCode(response);

            if(response.body() != null){
                glucoses.addAll(response.body().getBGDataList());
            }
        }

        return glucoses;
    }

    public List<BloodPressure> downloadBloodPressures() throws HttpCodeException, IOException {
        List<BloodPressure> bp = new ArrayList<>();

        Call<BloodPressureResult> call = service.getBloodPressures(accessInfo.getUserID(),requiredParameters, getApi(OpenApis.ACTIVITY).getSC(), getApi(OpenApis.ACTIVITY).getSV());
        Response<BloodPressureResult> response = call.execute();
        IHealthManager.validateResponseCode(response);

        if(response.body()!=null){
            bp.addAll(response.body().getBPDataList());
        }

        while (response.body().getNextPageUrl().length() > 0){
            call = service.getBloodPressuresNextPage(response.body().getNextPageUrl());
            response = call.execute();
            IHealthManager.validateResponseCode(response);

            if(response.body() != null){
                bp.addAll(response.body().getBPDataList());
            }
        }

        return bp;
    }

    public List<Sleep> downloadSleeps() throws HttpCodeException, IOException {
        List<Sleep> sleeps = new ArrayList<>();

        Call<SleepResult> call = service.getSleeps(accessInfo.getUserID(),requiredParameters, getApi(OpenApis.ACTIVITY).getSC(), getApi(OpenApis.ACTIVITY).getSV());
        Response<SleepResult> response = call.execute();
        IHealthManager.validateResponseCode(response);

        if(response.body()!=null){
            sleeps.addAll(response.body().getSRDataList());
        }

        while (response.body().getNextPageUrl().length() > 0){
            call = service.getSleepsNextPage(response.body().getNextPageUrl());
            response = call.execute();
            IHealthManager.validateResponseCode(response);

            if(response.body() != null){
                sleeps.addAll(response.body().getSRDataList());
            }
        }

        return sleeps;
    }


}
