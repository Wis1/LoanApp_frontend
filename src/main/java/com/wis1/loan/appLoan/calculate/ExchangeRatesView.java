package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.service.NBPService;

@Route(value = "exchange_rates")
@StyleSheet("/css/style.css")
public class ExchangeRatesView extends VerticalLayout {
    private final TextArea euroRate= new TextArea("Actual euro rate");
    private final TextArea usdRate= new TextArea("Actual dollar rate");
    private final TextArea chfRate= new TextArea("Actual frank rate");
    private final NBPService nbpService= new NBPService();
    private final Button menuButton= new Button("Menu");

    public ExchangeRatesView(){
        HorizontalLayout hl= new HorizontalLayout();
        hl.add(euroRate, usdRate, chfRate);
        add(hl, menuButton);
        menuButton.addClickListener(click-> UI.getCurrent().navigate(""));
        euroRate.setValue(nbpService.getEuroRate());
        usdRate.setValue(nbpService.getUsdRate());
        chfRate.setValue(nbpService.getChfRate());
        setSizeFull();
    }
}
