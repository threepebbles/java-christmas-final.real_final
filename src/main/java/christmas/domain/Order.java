package christmas.domain;

import christmas.error.ErrorMessage;
import christmas.view.output.dto.OrderDto;

public class Order {
    public static final int AVAILABLE_COUNT = 20;

    private final Menu menu;
    private final int count;

    public Order(Menu menu, int count) {
        validateMenuName(menu.getName());
        validateCount(count);
        this.menu = menu;
        this.count = count;
    }

    private void validateCount(int count) {
        if (count <= 0 || count > AVAILABLE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }

    private void validateMenuName(String menuName) {
        if (Menu.findMenuByName(menuName) == Menu.NOTHING) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }

    public OrderDto toDto() {
        return new OrderDto(menu.getName(), count);
    }

    public int calculateTotalPrice() {
        return menu.getPrice() * count;
    }

    public boolean isEqualMenuType(MenuType menuType) {
        return menu.getMenuType().equals(menuType);
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getCount() {
        return count;
    }
}
