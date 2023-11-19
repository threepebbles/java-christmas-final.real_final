package christmas.domain;

import christmas.error.ErrorMessage;
import christmas.view.input.dto.OrdersInputDto;
import christmas.view.output.dto.OrdersDto;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    public static final int AVAILABLE_COUNT = 20;
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        validateCount(orders);
        validateDuplicatedMenu(orders);
        this.orders = orders;
    }

    private void validateDuplicatedMenu(List<Order> orders) {
        if (orders.stream()
                .map(Order::getMenuName)
                .distinct().count() != orders.size()) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }

    private void validateCount(List<Order> orders) {
        if (orders.stream()
                .mapToInt(Order::getCount)
                .sum() > AVAILABLE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }

    public static Orders createOrders(OrdersInputDto ordersInputDTO) {
        return new Orders(new ArrayList<>() {{
            ordersInputDTO.getOrders().forEach(orderInputDTO ->
                    add(new Order(
                            Menu.findMenuByName(orderInputDTO.getMenuName()),
                            orderInputDTO.getCount())
                    )
            );
        }});
    }

    public OrdersDto toDto() {
        return new OrdersDto(orders.stream()
                .map(Order::toDto)
                .toList());
    }

    public int calculateTotalPrice() {
        return orders.stream()
                .mapToInt(Order::calculateTotalPrice)
                .sum();
    }

    public int countByMenuType(MenuType menuType) {
        return orders.stream()
                .filter(order -> order.isEqualMenuType(menuType))
                .mapToInt(Order::getCount)
                .sum();
    }
}