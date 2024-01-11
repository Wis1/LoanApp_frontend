package com.wis1.loan.appLoan.calculate.service;

import com.wis1.loan.appLoan.calculate.domain.CalcResultDto;
import com.wis1.loan.appLoan.calculate.domain.Calculate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateService {

    RestTemplate restTemplate = new RestTemplate();
    private static CalculateService calculateService;

    public Calculate getById(Long id) {
        try {
            return restTemplate.getForObject("http://localhost:8080/v1/calculate/" + id, Calculate.class);
        } catch (RestClientException e) {
            return null;
        }
    }

    public Calculate getCalculateById(Long id) {
        try {
            return restTemplate.getForObject("http://localhost:8080/v1/calculate/onecalculate/"+id, Calculate.class);
        } catch (RestClientException e) {
            return null;
        }
    }

    public CalcResultDto getCalc(Integer amountLoan, Integer loanLength) {
        try {
            return restTemplate.getForObject("http://localhost:8080/v1/calcApi/" + amountLoan + "/" + loanLength, CalcResultDto.class);
        } catch (RestClientException e) {
            return new CalcResultDto();
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
            Calculate[] calculates = restTemplate.getForObject("http://localhost:8080/v1/calculate", Calculate[].class);
            return Arrays.asList(calculates);
        } catch (RestClientException e) {
            return new ArrayList<>();
        }
    }

    public void saveCalculate(Long clientId, Integer amount, Integer length, CalcResultDto calculate) {
        Calculate calculate1 = new Calculate();
        calculate1.setId(amount.longValue()/length);
        calculate1.setAmountLoan(amount);
        calculate1.setLoanLength(length);
        calculate1.setCalculate(calculate);
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/calculate/" + clientId)
                .queryParam("amountLoan", calculate1.getAmountLoan())
                .queryParam("loanLength", calculate1.getLoanLength())
                .queryParam("calculate", calculate1.getCalculate())
                .build().encode().toUri();
        restTemplate.postForEntity(url, calculate1, Void.class);
    }

    public void deleteCalculate(Long calculateId) {
        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/calculate/" + calculateId)
                .build().encode().toUri();
        restTemplate.delete(url);
    }
}
