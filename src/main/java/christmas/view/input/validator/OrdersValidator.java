package christmas.view.input.validator;

import christmas.error.ErrorMessage;
import christmas.util.Parser;
import java.util.List;
import java.util.Objects;

public class OrdersValidator implements InputValidator {
    private static final OrdersValidator ordersValidator = new OrdersValidator();

    private OrdersValidator() {
    }

    public static OrdersValidator getInstance() {
        return ordersValidator;
    }

    @Override
    public void validate(String target) {
        validateNull(target);
        validateBlank(target);
        List<String> menuCounts = Parser.parseWithDelimiter(target, ",");
        menuCounts.forEach(this::validateOrderFormat);
    }

    private void validateOrderFormat(String target) {
        List<String> menuCount = Parser.parseWithDelimiter(target, "-");
        if (menuCount.size() != 2) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
        String menuName = menuCount.get(0);
        String count = menuCount.get(1);
        validateBlank(menuName);
        validateBlank(count);
        validateInteger(count);
    }

    private void validateBlank(String menuName) {
        if (menuName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }

    private void validateInteger(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }

    private void validateNull(String target) {
        if (Objects.isNull(target)) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }
}