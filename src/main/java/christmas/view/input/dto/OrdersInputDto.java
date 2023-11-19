package christmas.view.input.dto;

import java.util.List;

public class OrdersInputDto {
    private final List<OrderInputDto> orders;

    public OrdersInputDto(List<OrderInputDto> orders) {
        this.orders = orders;
    }

    public List<OrderInputDto> getOrders() {
        return orders;
    }
}
