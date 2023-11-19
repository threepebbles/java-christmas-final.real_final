package christmas.view.input.dto;

import christmas.error.ErrorMessage;
import java.util.Objects;

public class OrderInputDto {
    private final String menuName;
    private final int count;

    public OrderInputDto(String menuName, int count) {
        validateBlank(menuName);
        validatePositiveInteger(count);
        this.menuName = menuName;
        this.count = count;
    }

    private void validateBlank(String menuName) {
        if (Objects.isNull(menuName) || menuName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }

    private void validatePositiveInteger(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ErrorMessage.getOrdersErrorMessage());
        }
    }

    public String getMenuName() {
        return menuName;
    }

    public int getCount() {
        return count;
    }
}
