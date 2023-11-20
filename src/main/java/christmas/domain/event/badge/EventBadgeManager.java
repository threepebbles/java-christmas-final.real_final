package christmas.domain.event.badge;

public class EventBadgeManager {
    public EventBadge requestEventBadge(int totalDiscount) {
        for (EventBadge eventBadge : EventBadge.values()) {
            if (eventBadge.isNotLessThanThreshold(totalDiscount)) {
                return eventBadge;
            }
        }
        return EventBadge.NOTHING;
    }
}