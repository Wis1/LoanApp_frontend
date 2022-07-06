package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.service.CalcResultService;
import com.wis1.loan.appLoan.calculate.service.NBPService;


@Route("")
public class MainView extends VerticalLayout {

    private CalcResultService resultService= CalcResultService.getInstance();

    private Button showActualRatesButton = new Button("show actual rates");
    private NBPService nbpService= new NBPService();
    private Button newCalculate= new Button("new Calculate");
    private Button oldCalculate= new Button("show last calculations");


    public MainView() {

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        showActualRatesButton.addClickListener(click->UI.getCurrent().navigate("exchange_rates"));
        newCalculate.addClickListener(click-> UI.getCurrent().navigate("new_calculate"));
        oldCalculate.addClickListener(click-> UI.getCurrent().navigate("old_calculate"));
        add(showActualRatesButton,newCalculate, oldCalculate);
        setSizeFull();

    }
}
