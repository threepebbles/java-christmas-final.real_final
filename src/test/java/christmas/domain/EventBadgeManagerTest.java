package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.badge.EventBadge;
import christmas.domain.event.badge.EventBadgeManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventBadgeManagerTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 4999})
    void 없음_테스트(int totalDiscount) {
        EventBadgeManager eventBadgeManager = new EventBadgeManager();
        EventBadge eventBadge = eventBadgeManager.requestEventBadge(totalDiscount);

        assertThat(eventBadge).isEqualTo(EventBadge.NOTHING);
    }

    @ParameterizedTest
    @ValueSource(ints = {5000, 9999})
    void 별_테스트(int totalDiscount) {
        EventBadgeManager eventBadgeManager = new EventBadgeManager();
        EventBadge eventBadge = eventBadgeManager.requestEventBadge(totalDiscount);

        assertThat(eventBadge).isEqualTo(EventBadge.STAR);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 19999})
    void 트리_테스트(int totalDiscount) {
        EventBadgeManager eventBadgeManager = new EventBadgeManager();
        EventBadge eventBadge = eventBadgeManager.requestEventBadge(totalDiscount);

        assertThat(eventBadge).isEqualTo(EventBadge.TREE);
    }

    @ParameterizedTest
    @ValueSource(ints = {20000, 30000})
    void 산타_테스트(int totalDiscount) {
        EventBadgeManager eventBadgeManager = new EventBadgeManager();
        EventBadge eventBadge = eventBadgeManager.requestEventBadge(totalDiscount);

        assertThat(eventBadge).isEqualTo(EventBadge.SANTA);
    }
}
