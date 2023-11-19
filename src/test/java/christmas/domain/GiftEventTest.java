package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.event.gift.GiftEvent;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class GiftEventTest {
    @Test
    void 자격_요건_충족_테스트() {
        Orders orders = new Orders(
                new ArrayList<>() {{
                    add(new Order(Menu.BARBECUE_LIP, 2));
                    add(new Order(Menu.ZERO_COKE, 4));
                    add(new Order(Menu.CAESAR_SALAD, 2));
                }}
        );
        // 108000 + 12000 + 16000 >= 120000
        GiftEvent giftEvent = new GiftEvent(orders);

        assertThat(giftEvent.isQualified()).isTrue();
    }

    @Test
    void 자격_요건_불충족_테스트() {
        Orders orders = new Orders(
                new ArrayList<>() {{
                    add(new Order(Menu.BARBECUE_LIP, 2));
                    add(new Order(Menu.ZERO_COKE, 3));
                }}
        );
        // 108000 + 9000 < 120000
        GiftEvent giftEvent = new GiftEvent(orders);

        assertThat(giftEvent.isQualified()).isFalse();
    }


    @Test
    void 자격_요건_충족_선물_가격_계산_테스트() {
        Orders orders = new Orders(
                new ArrayList<>() {{
                    add(new Order(Menu.BARBECUE_LIP, 2));
                    add(new Order(Menu.ZERO_COKE, 4));
                    add(new Order(Menu.CAESAR_SALAD, 2));
                }}
        );

        GiftEvent giftEvent = new GiftEvent(orders);

        assertThat(giftEvent.calculateDiscountAmount()).isEqualTo(25000);
    }

    @Test
    void 자격_요건_불충족_선물_가격_계산_테스트() {
        Orders orders = new Orders(
                new ArrayList<>() {{
                    add(new Order(Menu.BARBECUE_LIP, 2));
                    add(new Order(Menu.ZERO_COKE, 3));
                }}
        );

        GiftEvent giftEvent = new GiftEvent(orders);

        assertThat(giftEvent.calculateDiscountAmount()).isEqualTo(0);
    }
}
