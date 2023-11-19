package christmas.view.input;

import christmas.view.input.validator.DayOfVisitValidator;
import christmas.view.input.validator.InputValidator;
import christmas.view.input.validator.OrdersValidator;
import java.util.HashMap;
import java.util.Map;

public class InputValidatorFinder {
    private final Map<InputType, InputValidator> inputValidatorStore;

    public InputValidatorFinder() {
        inputValidatorStore = new HashMap<>() {{
            put(InputType.DAY_OF_VISIT, DayOfVisitValidator.getInstance());
            put(InputType.ORDERS, OrdersValidator.getInstance());
        }};
    }

    public InputValidator findByInputType(InputType inputType) {
        return inputValidatorStore.get(inputType);
    }
}
