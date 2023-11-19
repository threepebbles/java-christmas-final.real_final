package christmas.domain.event.discount;

import christmas.view.output.dto.DiscountResultDto;

public class DiscountResult {
    private final DiscountType discountType;
    private final int amount;

    public DiscountResult(DiscountType discountType, int amount) {
        this.discountType = discountType;
        this.amount = amount;
    }

    public DiscountResultDto toDto() {
        return new DiscountResultDto(discountType.getName(), amount);
    }

    public boolean isAmountNotZero() {
        return amount != 0;
    }
}