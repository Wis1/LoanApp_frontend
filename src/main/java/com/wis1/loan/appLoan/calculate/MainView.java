package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.service.CalcResultService;
import com.wis1.loan.appLoan.calculate.service.NBPService;


@Route("")
@StyleSheet("src/main/frontend/style.css")
public class MainView extends VerticalLayout {

    private final CalcResultService resultService= CalcResultService.getInstance();

    private final Button showActualRatesButton = new Button("show actual rates");
    private final NBPService nbpService= new NBPService();
    private final Button newCalculate= new Button("new Calculate");
    private final Button oldCalculate= new Button("show last calculations");


    public MainView() {

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("background","#696969");
        getStyle().set("color","black");
        showActualRatesButton.addClickListener(click->UI.getCurrent().navigate("exchange_rates"));
        newCalculate.addClickListener(click-> UI.getCurrent().navigate("new_calculate"));
        oldCalculate.addClickListener(click-> UI.getCurrent().navigate("old_calculate"));
        add(showActualRatesButton,newCalculate, oldCalculate);
        setSizeFull();

    }
}
