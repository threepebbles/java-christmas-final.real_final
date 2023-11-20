package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.discount.ChristmasDDayDiscountEvent;
import christmas.domain.event.discount.DiscountEvent;
import christmas.domain.event.discount.DiscountEventManager;
import christmas.domain.event.discount.SpecialDayDiscountEvent;
import christmas.domain.event.discount.WeekDayDiscountEvent;
import christmas.domain.event.discount.WeekendDiscountEvent;
import christmas.domain.event.gift.GiftEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DiscountEventManagerTest {
    @Test
    void 총혜택_금액_계산_테스트() {
        Date date = new Date(LocalDate.of(2023, 12, 25));
        Orders orders = new Orders(
                new ArrayList<>() {{
                    add(new Order(Menu.BARBECUE_LIP, 2));
                    add(new Order(Menu.ZERO_COKE, 4));
                    add(new Order(Menu.ICE_CREAM, 4));
                    add(new Order(Menu.CAESAR_SALAD, 2));
                }}
        );

        List<DiscountEvent> discountEvents = List.of(
                new ChristmasDDayDiscountEvent(date),    // 3400
                new WeekDayDiscountEvent(date, orders), // 2023*4
                new WeekendDiscountEvent(date, orders),    // 0
                new SpecialDayDiscountEvent(date),      // 1000
                new GiftEvent(orders)   // 25000
        );

        DiscountEventManager discountEventManager = new DiscountEventManager(discountEvents);
        int expected = 3400 + 2023 * 4 + 1000 + 25000;

        int actual = discountEventManager.calculateTotalDiscount();
        assertThat(actual).isEqualTo(expected);
    }
}
