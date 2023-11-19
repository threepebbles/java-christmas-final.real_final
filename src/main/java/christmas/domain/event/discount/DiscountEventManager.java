package christmas.domain.event.discount;

import java.util.List;

public class DiscountEventManager {
    public List<DiscountEvent> discountEvents;

    public DiscountEventManager(List<DiscountEvent> discountEvents) {
        this.discountEvents = discountEvents;
    }

    public DiscountResults calculateDiscountResults() {
        return new DiscountResults(discountEvents.stream()
                .map(DiscountEvent::calculateDiscountResult)
                .filter(DiscountResult::isAmountNotZero)
                .toList());
    }

    public int calculateTotalDiscount() {
        return discountEvents.stream()
                .mapToInt(DiscountEvent::calculateDiscountAmount)
                .sum();
    }

    public int calculateTotalDiscountWithoutGifts() {
        return discountEvents.stream()
                .filter(discountEvent -> discountEvent.getType() != DiscountType.GIFT)
                .mapToInt(DiscountEvent::calculateDiscountAmount)
                .sum();
    }
}