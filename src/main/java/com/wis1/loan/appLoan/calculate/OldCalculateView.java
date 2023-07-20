package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.domain.CalcResultDto;
import com.wis1.loan.appLoan.calculate.domain.Calculate;
import com.wis1.loan.appLoan.calculate.service.CalculateService;

@Route(value = "old_calculate")
public class OldCalculateView extends VerticalLayout {

    private final Grid<Calculate> grid= new Grid<>(Calculate.class);
    private final CalculateService calculateService=CalculateService.getInstance();
    private final Grid<CalcResultDto> grid2= new Grid<>(CalcResultDto.class);
    private final Button newCalculateButton= new Button("new Calculate");
    private final Button menuButton= new Button("menu");



    public OldCalculateView() {

        grid.getColumnByKey("id").setVisible(false);
//        grid.getColumnByKey("calculate").setVisible(false);
        grid.getStyle().set("background", "#696969");
//        grid.addColumn(calculate->calculate.getCalculate().getMonthly_payment()).setHeader("Monthly Paymant");
        grid.addComponentColumn(item -> new Button("delete", click-> {
            calculateService.deleteCalculate(item.getId());
            refresh();
        }));

        add(grid, newCalculateButton, menuButton);

        getStyle().set("background","#696969");
        getStyle().set("color","black");

        menuButton.addClickListener(click->UI.getCurrent().navigate(""));
        newCalculateButton.addClickListener(click-> UI.getCurrent().navigate("new_calculate"));
        setSizeFull();
        refresh();
    }

    public void refresh() {
        grid.setItems(calculateService.getCalculate());
    }
}
