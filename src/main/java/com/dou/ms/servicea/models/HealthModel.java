package com.dou.ms.servicea.models;

public class HealthModel {

    private String service;
    private String version;

    public HealthModel() {
    }

    public HealthModel(String service, String version) {
        this.service = service;
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
