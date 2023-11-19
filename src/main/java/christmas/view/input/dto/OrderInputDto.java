package christmas.view.input.dto;

public class OrderInputDto {
    private final String menuName;
    private final int count;

    public OrderInputDto(String menuName, int count) {

        this.menuName = menuName;
        this.count = count;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getCount() {
        return count;
    }
}
