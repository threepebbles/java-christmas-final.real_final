package christmas.view.input;

import christmas.error.ErrorMessage;
import christmas.util.Parser;
import christmas.view.input.dto.DateInputDto;
import christmas.view.input.dto.OrderInputDto;
import christmas.view.input.dto.OrdersInputDto;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InputDtoConverter {
    public DateInputDto createDateDTO(String userInput) {
        try {
            final int CURRENT_YEAR = 2023;
            final int CURRENT_MONTH = 12;
            int day = Integer.parseInt(userInput);
            return new DateInputDto(LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, day));
        } catch (DateTimeException | NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.getDateErrorMessage());
        }
    }

    public OrdersInputDto createOrdersInputDto(String userInput) {
        List<OrderInputDto> orders = new ArrayList<>();
        List<String> menuCounts = Parser.parseWithDelimiter(userInput, ",");
        menuCounts.forEach(menuCount -> {
            orders.add(createOrderInputDto(menuCount));
        });
        return new OrdersInputDto(orders);
    }

    private OrderInputDto createOrderInputDto(String menuCount) {
        List<String> menuCountBundle = Parser.parseWithDelimiter(menuCount, "-");
        try {
            String menuName = menuCountBundle.get(0);
            int count = Integer.parseInt(menuCountBundle.get(1));
            return new OrderInputDto(menuName, count);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }
}