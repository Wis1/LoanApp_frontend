package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.domain.Calculate;
import com.wis1.loan.appLoan.calculate.domain.CalculateService;

@Route
public class MainView extends VerticalLayout {

    private CalculateService calculateService= CalculateService.getInstance();
    private Grid<Calculate> grid= new Grid<>(Calculate.class);

    public MainView() {
        grid.setColumns("id","amountLoan", "loanLength");
        add(grid);
        setSizeFull();
        refresh();
    }

    public void refresh() {
        grid.setItems(calculateService.getCalculate());
    }

}
