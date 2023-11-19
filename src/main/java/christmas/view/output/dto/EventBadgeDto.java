package christmas.view.output.dto;

public class EventBadgeDto {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private final String eventBadgeName;

    public EventBadgeDto(String eventBadgeName) {
        this.eventBadgeName = eventBadgeName;
    }

    @Override
    public String toString() {
        if (eventBadgeName.isEmpty() || eventBadgeName.isBlank()) {
            return "없음";
        }
        return eventBadgeName;
    }
}
