package com.anext.ihealthmodule.model;

/**
 * Created by AnextCZ on 04/08/17.
 */

public class OpenApi {
    private String name;
    private String SC;
    private String SV;

    public OpenApi(String name, String SC, String SV){
        this.name = name;
        this.SC = SC;
        this.SV = SV;
    }

    public String getName() {
        return name;
    }

    public String getSC() {
        return SC;
    }

    public String getSV() {
        return SV;
    }

    @Override
    public String toString() {
        return "OpenApi{" +
                "name='" + name + '\'' +
                ", SC='" + SC + '\'' +
                ", SV='" + SV + '\'' +
                '}';
    }
}
