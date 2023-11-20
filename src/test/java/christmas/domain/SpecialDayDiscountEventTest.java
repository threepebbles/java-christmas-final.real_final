package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.discount.SpecialDayDiscountEvent;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class SpecialDayDiscountEventTest {
    @Test
    void 특별_할인_별이_있는_날_테스트() {
        Date date = new Date(LocalDate.of(2023, 12, 24));
        SpecialDayDiscountEvent specialDayDiscountEvent = new SpecialDayDiscountEvent(date);

        assertThat(specialDayDiscountEvent.calculateDiscountAmount())
                .isEqualTo(1000);
    }

    @Test
    void 특별_할인_별이_없는_날_테스트() {
        Date date = new Date(LocalDate.of(2023, 12, 26));
        SpecialDayDiscountEvent specialDayDiscountEvent = new SpecialDayDiscountEvent(date);

        assertThat(specialDayDiscountEvent.calculateDiscountAmount())
                .isEqualTo(0);
    }
}