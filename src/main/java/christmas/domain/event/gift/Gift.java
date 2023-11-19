package christmas.domain.event.gift;

import christmas.view.output.dto.GiftDto;

public enum Gift {
    CHAMPAGNE("샴페인", 25000);

    private final String name;
    private final int price;

    Gift(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public GiftDto toDto() {
        return new GiftDto(name, price);
    }

    public int getPrice() {
        return price;
    }
}
