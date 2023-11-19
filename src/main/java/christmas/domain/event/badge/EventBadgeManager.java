package christmas.domain.event.badge;

public class EventBadgeManager {
    public EventBadge requestEventBadge(int totalDiscount) {
        for (EventBadge eventBadge : EventBadge.values()) {
            if (eventBadge.isGreaterOrEqualThanThreshold(totalDiscount)) {
                return eventBadge;
            }
        }
        return EventBadge.NOTHING;
    }
}
