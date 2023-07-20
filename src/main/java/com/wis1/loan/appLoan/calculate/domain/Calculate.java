package com.wis1.loan.appLoan.calculate.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Calculate {

    private Long id;
    private Integer amountLoan;
    private Integer loanLength;
    private CalcResultDto calculate;
}
