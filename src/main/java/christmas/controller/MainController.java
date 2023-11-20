package christmas.controller;

import christmas.domain.Date;
import christmas.domain.EventPlan;
import christmas.domain.Orders;
import christmas.service.EventPlanningService;
import christmas.view.input.InputView;
import christmas.view.output.OutputView;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Date date = askDate();
        Orders orders = askOrders();

        EventPlanningService eventPlanningService = new EventPlanningService(date, orders);
        EventPlan eventPlan = eventPlanningService.planningEvents(date, orders);

        outputView.printEventPlan(eventPlan.toDto());
    }

    private Date askDate() {
        return (Date) retryUntilSuccess(() -> Date.createDate(inputView.askDateInputDto()));
    }

    private Orders askOrders() {
        return (Orders) retryUntilSuccess(() -> Orders.createOrders(inputView.askOrdersInputDto()));
    }

    private <T> Object retryUntilSuccess(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                inputView.printMessage(e.getMessage());
            }
        }
    }
}