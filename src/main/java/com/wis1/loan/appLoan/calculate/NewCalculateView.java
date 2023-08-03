package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.domain.CalcResultDto;
import com.wis1.loan.appLoan.calculate.service.CalculateService;

@Route(value = "new_calculate")
@StyleSheet("/css/style.css")
public class NewCalculateView extends HorizontalLayout {

    private final CalculateService calculateService= new CalculateService();
    private final IntegerField textField= new IntegerField("Write an amount loan");
    private final IntegerField textLoanLength= new IntegerField("Write a loan length (in months) ");
    private final Button calculate= new Button("Calculate");
    private final TextArea textArea= new TextArea();
    private final Button saveButton= new Button("Save");
    private final Button showCalculatesButton= new Button("Show saved calculates");
    private final Button menuButton= new Button("Menu");
    private CalcResultDto calcResultDto = new CalcResultDto();

    public NewCalculateView(){
        setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        textArea.setReadOnly(true);
        textField.setMinWidth("200px");
        textLoanLength.setMinWidth("250px");
        add(textField, textLoanLength, calculate, textArea, saveButton, showCalculatesButton, menuButton);

        menuButton.addClickListener(click->UI.getCurrent().navigate(""));

        showCalculatesButton.addClickListener(click-> UI.getCurrent().navigate("old_calculate"));
        calculate.addClickListener(click-> {
            calcResultDto = calculateService.getCalc(textField.getValue(), textLoanLength.getValue());
            textArea.setValue(calcResultDto.toString());
        });

        saveButton.addClickListener(click-> {
                    calculateService.saveCalculate(60L, textField.getValue(), textLoanLength.getValue(), calcResultDto);
                    Notification notification = new Notification("Calculate saved", 3000);
                    notification.open();
                }
        );
    }
}
