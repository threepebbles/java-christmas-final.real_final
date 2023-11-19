package christmas.domain.event.gift;

import christmas.domain.Orders;
import christmas.domain.event.discount.DiscountEvent;
import christmas.domain.event.discount.DiscountResult;
import christmas.domain.event.discount.DiscountType;
import java.util.ArrayList;

public class GiftEvent implements DiscountEvent {
    public static final int MINIMUM_AMOUNT_TO_RECEIVE_GIFT = 120000;
    public static final Gifts gifts = new Gifts(new ArrayList<>() {{
        add(Gift.CHAMPAGNE);
    }});
    private final DiscountType discountType = DiscountType.GIFT;
    public final Orders orders;

    public GiftEvent(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int calculateDiscountAmount() {
        if (isQualified()) {
            return gifts.calculateTotalPrice();
        }
        return 0;
    }

    public boolean isQualified() {
        return orders.calculateTotalPrice() >= MINIMUM_AMOUNT_TO_RECEIVE_GIFT;
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