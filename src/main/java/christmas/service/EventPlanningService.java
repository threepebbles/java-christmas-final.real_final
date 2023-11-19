package christmas.service;

import christmas.domain.Date;
import christmas.domain.EventPlan;
import christmas.domain.Orders;
import christmas.domain.event.badge.EventBadge;
import christmas.domain.event.badge.EventBadgeManager;
import christmas.domain.event.discount.ChristmasDDayDiscountEvent;
import christmas.domain.event.discount.DiscountEvent;
import christmas.domain.event.discount.DiscountEventManager;
import christmas.domain.event.discount.DiscountResults;
import christmas.domain.event.discount.SpecialDayDiscountEvent;
import christmas.domain.event.discount.WeekDayDiscountEvent;
import christmas.domain.event.discount.WeekendDiscountEvent;
import christmas.domain.event.gift.GiftEvent;
import christmas.domain.event.gift.GiftEventManager;
import christmas.domain.event.gift.Gifts;
import java.util.List;

public class EventPlanningService {
    public static final int MINIMUM_REQUIRED_AMOUNT_TO_PLAN_EVENT = 10_000;

    private final GiftEventManager giftEventManager;
    private final DiscountEventManager discountEventManager;
    private final EventBadgeManager eventBadgeManager;

    public EventPlanningService(Date date, Orders orders) {
        List<DiscountEvent> eventsInProgress = List.of(
                new ChristmasDDayDiscountEvent(date),
                new WeekDayDiscountEvent(date, orders),
                new WeekendDiscountEvent(date, orders),
                new SpecialDayDiscountEvent(date),
                new GiftEvent(orders)
        );
        discountEventManager = new DiscountEventManager(eventsInProgress);
        giftEventManager = new GiftEventManager(new GiftEvent(orders));
        eventBadgeManager = new EventBadgeManager();
    }

    public EventPlan planningEvents(Date date, Orders orders) {
        if (orders.calculateTotalPrice() >= MINIMUM_REQUIRED_AMOUNT_TO_PLAN_EVENT) {
            return createEventPlan(date, orders);
        }
        return createDefaultPlan(date, orders);
    }

    private EventPlan createEventPlan(Date date, Orders orders) {
        return new EventPlan(
                date,
                orders,
                orders.calculateTotalPrice(),
                giftEventManager.requestGifts(),
                discountEventManager.calculateDiscountResults(),
                discountEventManager.calculateTotalDiscount(),
                orders.calculateTotalPrice()
                        - discountEventManager.calculateTotalDiscountWithoutGifts(),
                eventBadgeManager.requestEventBadge(discountEventManager.calculateTotalDiscount())
        );
    }

    private EventPlan createDefaultPlan(Date date, Orders orders) {
        return new EventPlan(
                date,
                orders,
                orders.calculateTotalPrice(),
                Gifts.createEmptyGifts(),
                DiscountResults.createEmptyDiscountResults(),
                0,
                orders.calculateTotalPrice(),
                EventBadge.NOTHING
        );
    }
}