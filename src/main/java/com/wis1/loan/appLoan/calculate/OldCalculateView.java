package com.wis1.loan.appLoan.calculate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.wis1.loan.appLoan.calculate.domain.CalcResultDto;
import com.wis1.loan.appLoan.calculate.domain.Calculate;
import com.wis1.loan.appLoan.calculate.service.CalculateService;

@Route(value = "old_calculate")
@StyleSheet("/css/style.css")
public class OldCalculateView extends VerticalLayout {

    private final Grid<Calculate> grid= new Grid<>(Calculate.class);
    private final CalculateService calculateService=CalculateService.getInstance();
    private final Grid<CalcResultDto> grid2= new Grid<>(CalcResultDto.class);
    private final Button newCalculateButton= new Button("New Calculate");
    private final Button menuButton= new Button("Menu");

    public OldCalculateView() {
        grid.getColumnByKey("id").setVisible(false);
        grid.addComponentColumn(item-> {
            String itemId = item.getId().toString();
            return new Button("View details", click -> UI.getCurrent().navigate("details/" + itemId));
        });
        grid.addComponentColumn(item -> new Button("delete", click-> {
            calculateService.deleteCalculate(item.getId());
            refresh();
        }));
        grid.getColumnByKey("amountLoan").setWidth("200px");
        grid.getColumnByKey("calculate").setWidth("800px");
        grid.getColumnByKey("loanLength").setWidth("200px");
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
