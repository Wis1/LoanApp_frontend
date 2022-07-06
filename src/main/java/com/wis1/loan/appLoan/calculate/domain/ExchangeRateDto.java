package com.wis1.loan.appLoan.calculate.domain;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateDto {

    private String currency;
    private List<RatesDto> ratesMid;

}
