package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@StyleSheet("/css/style.css")
public class MainView extends VerticalLayout {
    private final Button showActualRatesButton = new Button("Show actual rates");
    private final Button newCalculate= new Button("New calculation");
    private final Button oldCalculate= new Button("Show saved calculations");

    public MainView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        showActualRatesButton.addClickListener(click->UI.getCurrent().navigate("exchange_rates"));
        newCalculate.addClickListener(click-> UI.getCurrent().navigate("new_calculate"));
        oldCalculate.addClickListener(click-> UI.getCurrent().navigate("old_calculate"));
        add(showActualRatesButton,newCalculate, oldCalculate);
        setSizeFull();
    }
}
