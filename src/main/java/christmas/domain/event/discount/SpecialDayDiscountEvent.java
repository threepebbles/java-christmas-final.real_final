package christmas.domain.event.discount;

import christmas.domain.Date;
import java.time.LocalDate;
import java.util.List;

public class SpecialDayDiscountEvent implements DiscountEvent {
    public static final int DISCOUNT = 1000;
    public static final List<LocalDate> specialDays = List.of(
            LocalDate.of(2023, 12, 3),
            LocalDate.of(2023, 12, 10),
            LocalDate.of(2023, 12, 17),
            LocalDate.of(2023, 12, 24),
            LocalDate.of(2023, 12, 25),
            LocalDate.of(2023, 12, 31)
    );
    private final DiscountType discountType = DiscountType.SPECIAL;
    private final Date date;

    public SpecialDayDiscountEvent(Date date) {
        this.date = date;
    }

    @Override
    public boolean isQualified() {
        return specialDays.contains(date.getLocalDate());
    }
    
    @Override
    public int calculateDiscountAmount() {
        if (isQualified()) {
            return DISCOUNT;
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