package christmas.domain.event.badge;

import christmas.view.output.dto.EventBadgeDto;

public enum EventBadge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NOTHING("", 0);

    private final String name;
    private final int threshold;

    EventBadge(String name, int threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public EventBadgeDto toDto() {
        return new EventBadgeDto(name);
    }

    public boolean isNotLessThanThreshold(int totalDiscount) {
        return totalDiscount >= threshold;
    }
}