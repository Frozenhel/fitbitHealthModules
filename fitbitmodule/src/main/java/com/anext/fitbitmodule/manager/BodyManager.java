package com.anext.fitbitmodule.manager;

import com.anext.fitbitmodule.FitbitManager;
import com.anext.fitbitmodule.exception.HttpCodeException;
import com.anext.fitbitmodule.model.body.BodyFat;
import com.anext.fitbitmodule.model.body.BodyFatResponse;
import com.anext.fitbitmodule.model.body.BodyWeight;
import com.anext.fitbitmodule.model.body.BodyWeightResponse;
import com.anext.fitbitmodule.service.BodyService;
import com.anext.fitbitmodule.util.DateConvertor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Jiri on 31/07/17.
 */

public class BodyManager {
    private BodyService service;

    public BodyManager(BodyService service){
        this.service = service;
    }

    public List<BodyFat> downloadBodyFatForDay(Date date) throws IOException, HttpCodeException {
        if(date == null) date = new Date();
        List<BodyFat> bodyFats = new ArrayList<>();

        Call<BodyFatResponse> call = service.getBodyFatForDate(DateConvertor.convertDateToString(date));
        Response<BodyFatResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        if(response.body()!=null) bodyFats = response.body().getFat();

        return bodyFats;
    }

    public  List<BodyFat> downloadBodyFatForPeriod(Date startDate, String period) throws HttpCodeException, IOException {
        if(startDate == null) startDate = new Date();
        if(period == null || period.length() == 0) period = "1w";
        List<BodyFat> bodyFats = new ArrayList<>();

        Call<BodyFatResponse> call = service.getBodyFatForPeriod(DateConvertor.convertDateToString(startDate), period);
        Response<BodyFatResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        if(response.body()!=null){
            bodyFats = response.body().getFat();
        }

        return bodyFats;
    }

    public  List<BodyFat> downloadBodyFatForRange(Date startDate, Date endDate) throws IOException, HttpCodeException {
        if(startDate == null) startDate = new Date();
        if(endDate == null) endDate = new Date();
        List<BodyFat> bodyFats = new ArrayList<>();

        Call<BodyFatResponse> call = service.getBodyFatInDateRange(DateConvertor.convertDateToString(startDate),DateConvertor.convertDateToString(endDate));
        Response<BodyFatResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        if(response.body()!=null){
            bodyFats = response.body().getFat();
        }

        return bodyFats;
    }

    public List<BodyWeight> downloadBodyWeightForDay(Date date) throws HttpCodeException, IOException {
        if(date == null) date = new Date();
        List<BodyWeight> weights = new ArrayList<>();

        Call<BodyWeightResponse> call = service.getBodyWeightForDate(DateConvertor.convertDateToString(date));
        Response<BodyWeightResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        if(response.body()!=null){
            weights = response.body().getWeights();
        }

        return weights;
    }

    public List<BodyWeight> downloadBodyWeightForPeriod(Date startDate, String period) throws HttpCodeException, IOException {
        if(startDate == null) startDate = new Date();
        if(period == null || period.length() == 0) period = "1w";
        List<BodyWeight> weights = new ArrayList<>();

        Call<BodyWeightResponse> call = service.getBodyWeightForPeriod(DateConvertor.convertDateToString(startDate),period);
        Response<BodyWeightResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        if(response.body()!=null){
            weights = response.body().getWeights();
        }

        return weights;
    }

    public List<BodyWeight> downloadBodyWeightForRange(Date startDate, Date endDate) throws HttpCodeException, IOException {
        if(startDate == null) startDate = new Date();
        if(endDate == null) endDate = new Date();
        List<BodyWeight> weights = new ArrayList<>();

        Call<BodyWeightResponse> call = service.getBodyWeightInDateRange(DateConvertor.convertDateToString(startDate),DateConvertor.convertDateToString(endDate));
        Response<BodyWeightResponse> response = call.execute();
        FitbitManager.validateResponseCode(response);

        if(response.body()!=null){
            weights = response.body().getWeights();
        }

        return weights;
    }
}
