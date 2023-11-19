package christmas.domain.event.discount;

import christmas.domain.Date;
import christmas.domain.MenuType;
import christmas.domain.Orders;

public class WeekendDiscountEvent implements DiscountEvent {
    public static final int DISCOUNT_PER_MAIN = 2023;
    private final DiscountType discountType = DiscountType.WEEKEND;
    private final Date date;
    private final Orders orders;

    public WeekendDiscountEvent(Date date, Orders orders) {
        this.date = date;
        this.orders = orders;
    }

    @Override
    public boolean isQualified() {
        return date.isWeekend();
    }

    @Override
    public int calculateDiscountAmount() {
        if (isQualified()) {
            return orders.countByMenuType(MenuType.MAIN) * DISCOUNT_PER_MAIN;
        }
        return 0;
    }

    @Override
    public DiscountResult calculateDiscountResult() {
        return new DiscountResult(discountType, calculateDiscountAmount());
    }

    @Override
    public DiscountType getType() {
        return discountType;
    }
}