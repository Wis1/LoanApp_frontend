package com.wis1.loan.appLoan.calculate.service;

import com.wis1.loan.appLoan.calculate.domain.CalcResult;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CalcResultService {

    RestTemplate restTemplate= new RestTemplate();
    private static CalcResultService resultService;

    public List<CalcResult> getResult(Long id) {
//        try{
            CalcResult[] results= restTemplate.getForObject("http://localhost:8080/v1/calcApi/39", CalcResult[].class);
            System.out.println("getResult");
            return Arrays.asList(Objects.requireNonNull(results));
//        }catch (RestClientException e) {
//            return new ArrayList<>();
//        }
    }

    public static CalcResultService getInstance(){
        if (resultService==null) {
            resultService= new CalcResultService();
        }
        return resultService;
    }


}
