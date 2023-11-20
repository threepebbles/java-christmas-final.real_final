package christmas.domain.event.discount;

public enum DiscountType {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인"),
    WEEK_DAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    GIFT("증정 이벤트"),
    NOTHING("");
    
    private String name;

    DiscountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
