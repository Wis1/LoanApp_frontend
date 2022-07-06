package com.wis1.loan.appLoan.calculate.service;

import com.wis1.loan.appLoan.calculate.domain.ExchangeRateDto;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NBPService {

    RestTemplate restTemplate= new RestTemplate();
    private static NBPService nbpService;

    public static NBPService getInstance() {
        if (nbpService== null) {
            nbpService= new NBPService();
        }
        return nbpService;
    }

    public String getNBPResult(){
        try{
            String results= restTemplate.getForObject("http://localhost:8080/v1/nbp/information", String.class);
            return (Objects.requireNonNull(results));
        }catch (RestClientException e) {
            return new String();
        }
    }

    public String getEuroRate(){
        try{
            String euroRate= restTemplate.getForObject("http://localhost:8080/v1/nbp/eur/eur", String.class).toString();
            return euroRate;
        } catch (RestClientException e) {
            return new String();
        }
    }

    public String getUsdRate() {
        try{
            String usdRate= restTemplate.getForObject("http://localhost:8080/v1/nbp/usd/usd", String.class).toString();
            return usdRate;
        } catch (RestClientException e) {
            return new String();
        }
    }

    public String getChfRate() {
        try{
            String chfRate= restTemplate.getForObject("http://localhost:8080/v1/nbp/chf/chf", String.class).toString();
            return chfRate;
        } catch (RestClientException e) {
            return new String();
        }
    }
}
