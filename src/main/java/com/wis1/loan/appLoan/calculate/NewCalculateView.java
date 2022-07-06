package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.service.CalculateService;


@Route(value = "new_calculate")
public class NewCalculateView extends HorizontalLayout {

    private CalculateService calculateService= new CalculateService();
    private IntegerField textField= new IntegerField("write an amount loan");
    private IntegerField textLoanLength= new IntegerField("write a loan length (in months) ");
    private Button calculate= new Button("Calculate");
    private final TextArea textArea= new TextArea();
    private Button saveButton= new Button("SAVE");
    private Button showCalculatesButton= new Button("show saved calculates");
    private Button menuButton= new Button("menu");


    public NewCalculateView(){
        setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        textArea.setReadOnly(true);
        add(textField, textLoanLength, calculate, textArea, saveButton, showCalculatesButton, menuButton);

        menuButton.addClickListener(click->UI.getCurrent().navigate(""));

        showCalculatesButton.addClickListener(click-> UI.getCurrent().navigate("old_calculate"));
        saveButton.addClickListener(click->calculateService.saveCalculate(38L, textField.getValue(), textLoanLength.getValue()));
        calculate.addClickListener(click->textArea.setValue(calculateService.getCalc(textField.getValue(), textLoanLength.getValue())));

    }
}
