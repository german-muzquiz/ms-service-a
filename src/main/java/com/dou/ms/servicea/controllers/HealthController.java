package com.dou.ms.servicea.controllers;

import com.dou.ms.servicea.models.HealthModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/health")
public class HealthController {

    @Value("${service.name}")
    private String service;
    @Value("${service.version}")
    private String version;
    @Value("${service.environment}")
    private String environment;
    @Value("${service-b.url}")
    private String serviceBUrl;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public HealthModel getHealth() {
        HealthModel result = new HealthModel(service, version, environment);

        RestTemplate restTemplate = new RestTemplate();
        String serviceBHealth = restTemplate.getForObject(serviceBUrl, String.class);
        result.setServiceB(serviceBHealth);

        return result;
    }

}
