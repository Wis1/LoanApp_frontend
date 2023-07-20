package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.service.NBPService;

@Route(value = "exchange_rates")
public class ExchangeRatesView extends VerticalLayout {

    private TextArea euroRate= new TextArea("Actual euro rate");
    private TextArea usdRate= new TextArea("Actual dollar rate");
    private TextArea chfRate= new TextArea("Actual frank rate");
    private NBPService nbpService= new NBPService();
    private Button menuButton= new Button("menu");

    public ExchangeRatesView(){
        euroRate.getElement().getStyle().set("color", "black");
        HorizontalLayout hl= new HorizontalLayout();
        hl.add(euroRate, usdRate, chfRate);
        add(hl, menuButton);
        getStyle().set("background","#696969");
        menuButton.addClickListener(click-> UI.getCurrent().navigate(""));
        euroRate.setValue(nbpService.getEuroRate());
        usdRate.setValue(nbpService.getUsdRate());
        chfRate.setValue(nbpService.getChfRate());
        setSizeFull();
    }
}
