package christmas.view.output.dto;

public class OrderDto {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private final String menuName;
    private final int count;

    public OrderDto(String menuName, int count) {
        this.menuName = menuName;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%s %d개", menuName, count) + LINE_SEPARATOR;
    }
}