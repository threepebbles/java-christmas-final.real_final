package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class OrdersTest {
    @Test
    void 총가격_계산_테스트() {
        Orders orders = new Orders(
                new ArrayList<>() {{
                    add(new Order(Menu.BARBECUE_LIP, 2));
                    add(new Order(Menu.ZERO_COKE, 4));
                    add(new Order(Menu.CAESAR_SALAD, 2));
                }}
        );
        int expected = Menu.BARBECUE_LIP.getPrice() * 2
                + Menu.ZERO_COKE.getPrice() * 4
                + Menu.CAESAR_SALAD.getPrice() * 2;

        int actual = orders.calculateTotalPrice();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 특정_메뉴_타입_개수_계산_테스트() {
        Orders orders = new Orders(
                new ArrayList<>() {{
                    add(new Order(Menu.BARBECUE_LIP, 2));
                    add(new Order(Menu.ZERO_COKE, 4));
                    add(new Order(Menu.T_BONE_STEAK, 5));
                    add(new Order(Menu.CAESAR_SALAD, 3));
                }}
        );
        int mainCount = 2 + 5;
        int actual = orders.countByMenuType(MenuType.MAIN);

        assertThat(actual).isEqualTo(mainCount);
    }
}