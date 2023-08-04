package com.wis1.loan.appLoan.calculate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalcResultDto {

    private String interest_rate;
    private String loan_amount;
    private String loan_interest;
    private String loan_type;
    private String monthly_payment;
    private String repayment_term;
    private List<ScheduleItemDto> schedule;

    @Override
    public String toString() {
        return  "Interest rate: " + interest_rate  +
                ",   Loan interest: " + loan_interest +
                ",   Monthly payment: " + monthly_payment;
    }

    public String toDetailsString() {
        return "Calculation result: " + "\n\n" +
                "interest rate = " + interest_rate + "\n" +
                "loan amount = " + loan_amount + "\n"+
                "loan interest = " + loan_interest + "\n"+
                "loan type = " + loan_type + "\n"+
                "monthly payment = " + monthly_payment + "\n"+
                "repayment term = " + repayment_term + "\n"+
                "schedule = " + schedule;
    }
}

