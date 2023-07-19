package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.domain.CalcResult;
import com.wis1.loan.appLoan.calculate.domain.Calculate;
import com.wis1.loan.appLoan.calculate.service.CalculateService;

@Route(value = "old_calculate")
public class OldCalculateView extends VerticalLayout {

    private Grid<Calculate> grid= new Grid<>(Calculate.class);
    private CalculateService calculateService=CalculateService.getInstance();
    private Grid<CalcResult> grid2= new Grid<>(CalcResult.class);
    private Button newCalculateButton= new Button("new Calculate");
    private Button menuButton= new Button("menu");


    public OldCalculateView() {
        grid.addComponentColumn(item -> new Button("delete", click-> {
            calculateService.deleteCalculate(item.getId());
            refresh();
        }));
        add(grid, newCalculateButton, menuButton);

        menuButton.addClickListener(click->UI.getCurrent().navigate(""));
        newCalculateButton.addClickListener(click-> UI.getCurrent().navigate("new_calculate"));
        setSizeFull();
        refresh();
    }

    public void refresh() {
        grid.setItems(calculateService.getCalculate());
    }
}
