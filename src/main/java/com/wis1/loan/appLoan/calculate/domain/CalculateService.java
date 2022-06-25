package com.wis1.loan.appLoan.calculate.domain;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

public class CalculateService {

    RestTemplate restTemplate= new RestTemplate();
    private static CalculateService calculateService;

    public Calculate getById(Long id){
        try {
            Calculate calculate= restTemplate.getForObject("http://localhost:8080/v1/calculate/" +id, Calculate.class);
            return calculate;
        }catch (RestClientException e){
            return null;
        }
    }

    public static CalculateService getInstance() {
        if (calculateService == null) {
            calculateService = new CalculateService();
        }
        return calculateService;
    }

    public List<Calculate> getCalculate() {

        try {

            Calculate calculates= restTemplate.getForObject("http://localhost:8080/v1/calculate", Calculate.class);
            return Arrays.asList(ofNullable(calculates).orElse(new Calculate()));
        }catch (RestClientException e) {
            return new ArrayList<>();
        }
    }
}
