package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    void 가격합_계산_테스트() {
        Order order = new Order(Menu.BARBECUE_LIP, 4);
        int expected = Menu.BARBECUE_LIP.getPrice() * 4;

        int actual = order.calculateTotalPrice();

        assertThat(actual).isEqualTo(expected);
    }
}
