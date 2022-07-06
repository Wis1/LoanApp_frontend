package com.wis1.loan.appLoan.calculate.service;

import com.wis1.loan.appLoan.calculate.domain.Calculate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
    public String getCalc(Integer amountLoan, Integer loanLength){
        try{
            String calc= restTemplate.getForObject("http://localhost:8080/v1/calcApi/"+amountLoan+"/"+loanLength, String.class);
            return calc;
        }catch (RestClientException e) {
            return new String();
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
            Calculate[] calculates= restTemplate.getForObject("http://localhost:8080/v1/calculate", Calculate[].class);
            return Arrays.asList(calculates);
        }catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public void saveCalculate(Long clientId, Integer amount, Integer length) {
        Calculate calculate= new Calculate();
        calculate.setAmountLoan(amount);
        calculate.setLoanLength(length);
        URI url= UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/calculate/"+clientId)
                        .queryParam("amountLoan", calculate.getAmountLoan())
                                .queryParam("loanLength", calculate.getLoanLength())
                                        .build().encode().toUri();
        restTemplate.postForObject(url, calculate, Calculate.class);
    }
}
