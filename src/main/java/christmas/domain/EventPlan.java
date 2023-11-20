package christmas.domain;

import christmas.domain.event.badge.EventBadge;
import christmas.domain.event.discount.DiscountResults;
import christmas.domain.event.gift.Gifts;
import christmas.view.output.dto.EventPlanDto;

public class EventPlan {
    private Date date;
    private Orders orders;
    private int totalPriceBeforeDiscount;
    private Gifts gifts;
    private DiscountResults discountResults;
    private int totalDiscount;
    private int expectedPriceAfterDiscount;
    private EventBadge eventBadge;

    public EventPlan(Date date, Orders orders, int totalPriceBeforeDiscount, Gifts gifts,
                     DiscountResults discountResults, int totalDiscount, int expectedPriceAfterDiscount,
                     EventBadge eventBadge) {
        this.date = date;
        this.orders = orders;
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
        this.gifts = gifts;
        this.discountResults = discountResults;
        this.totalDiscount = totalDiscount;
        this.expectedPriceAfterDiscount = expectedPriceAfterDiscount;
        this.eventBadge = eventBadge;
    }

    public EventPlanDto toDto() {
        return new EventPlanDto(
                date.toDto(),
                orders.toDto(),
                totalPriceBeforeDiscount,
                gifts.toDto(),
                discountResults.toDTO(),
                totalDiscount,
                expectedPriceAfterDiscount,
                eventBadge.toDto()
        );
    }
}
