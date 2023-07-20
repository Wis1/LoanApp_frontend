package com.wis1.loan.appLoan.calculate.service;

import com.wis1.loan.appLoan.calculate.domain.CalcResultDto;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CalcResultService {

    RestTemplate restTemplate= new RestTemplate();
    private static CalcResultService resultService;

    public List<CalcResultDto> getResult(Long id) {
//        try{
            CalcResultDto[] results= restTemplate.getForObject("http://localhost:8080/v1/calcApi/39", CalcResultDto[].class);
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
