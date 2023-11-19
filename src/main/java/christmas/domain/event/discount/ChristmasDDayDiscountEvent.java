package christmas.domain.event.discount;

import christmas.domain.Date;
import java.time.LocalDate;
import java.time.Period;

public class ChristmasDDayDiscountEvent implements DiscountEvent {
    public static final int DEFAULT_DISCOUNT = 1000;
    public static final int DISCOUNT_PER_DAY = 100;
    public static final LocalDate DEAD_LINE = LocalDate.of(2023, 12, 25);
    private final DiscountType discountType = DiscountType.CHRISTMAS_D_DAY;

    private final Date date;

    public ChristmasDDayDiscountEvent(Date date) {
        this.date = date;
    }

    @Override
    public boolean isQualified() {
        return date.isBefore(DEAD_LINE) || date.isEqual(DEAD_LINE);
    }

    @Override
    public int calculateDiscountAmount() {
        if (isQualified()) {
            return DEFAULT_DISCOUNT + Period.between(date.getLocalDate(), DEAD_LINE).getDays() * DISCOUNT_PER_DAY;
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