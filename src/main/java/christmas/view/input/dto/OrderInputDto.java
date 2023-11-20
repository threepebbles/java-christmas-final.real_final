package christmas.view.input.dto;

import christmas.error.ErrorMessage;
import christmas.util.Parser;
import java.util.List;

public class OrderInputDto {
    private final String menuName;
    private final int count;

    public OrderInputDto(String menuName, int count) {
        this.menuName = menuName;
        this.count = count;
    }

    public static OrderInputDto createOrderInputDto(String menuCount) {
        List<String> menuCountBundle = Parser.parseWithDelimiter(menuCount, "-");
        try {
            String menuName = menuCountBundle.get(0);
            int count = Integer.parseInt(menuCountBundle.get(1));
            return new OrderInputDto(menuName, count);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
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
