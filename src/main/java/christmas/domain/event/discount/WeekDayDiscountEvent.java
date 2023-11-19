package christmas.domain.event.discount;

import christmas.domain.Date;
import christmas.domain.MenuType;
import christmas.domain.Orders;

public class WeekDayDiscountEvent implements DiscountEvent {
    public static final int DISCOUNT_PER_DESSERT = 2023;
    private final DiscountType discountType = DiscountType.WEEK_DAY;
    private final Date date;
    private final Orders orders;

    public WeekDayDiscountEvent(Date date, Orders orders) {
        this.date = date;
        this.orders = orders;
    }

    @Override
    public boolean isQualified() {
        return date.isWeekDay();
    }

    @Override
    public int calculateDiscountAmount() {
        if (isQualified()) {
            return orders.countByMenuType(MenuType.DESSERT) * DISCOUNT_PER_DESSERT;
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