package christmas.domain.event.discount;

public interface DiscountEvent {
    boolean isQualified();

    int calculateDiscountAmount();

    DiscountResult calculateDiscountResult();

    DiscountType getType();
}