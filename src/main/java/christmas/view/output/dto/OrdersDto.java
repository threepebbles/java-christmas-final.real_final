package christmas.view.output.dto;

import java.util.List;

public class OrdersDto {
    private final List<OrderDto> orders;

    public OrdersDto(List<OrderDto> orders) {
        this.orders = orders;
    }

    public List<OrderDto> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        orders.forEach(orderDto -> sb.append(orderDto.toString()));
        return sb.toString();
    }
}