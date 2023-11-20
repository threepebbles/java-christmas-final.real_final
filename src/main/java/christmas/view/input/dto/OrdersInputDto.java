package christmas.view.input.dto;

import christmas.util.Parser;
import java.util.ArrayList;
import java.util.List;

public class OrdersInputDto {
    private final List<OrderInputDto> orders;

    public OrdersInputDto(List<OrderInputDto> orders) {
        this.orders = orders;
    }
    
    public static OrdersInputDto createOrdersInputDto(String userInput) {
        List<OrderInputDto> orders = new ArrayList<>();
        List<String> menuCounts = Parser.parseWithDelimiter(userInput, ",");
        menuCounts.forEach(menuCount -> {
            orders.add(OrderInputDto.createOrderInputDto(menuCount));
        });
        return new OrdersInputDto(orders);
    }

    public List<OrderInputDto> getOrders() {
        return orders;
    }
}
