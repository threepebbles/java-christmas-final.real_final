package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConstructorValidationTest {
    @ParameterizedTest
    @ValueSource(ints = {2021, 2022, 2024, 2025})
    void 연도_예외_테스트(int year) {
        assertThatThrownBy(() -> new Date(LocalDate.of(year, 12, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
    void 달_예외_테스트(int month) {
        assertThatThrownBy(() -> new Date(LocalDate.of(2023, month, 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 이름이 주문할 수 없는 메뉴인 경우 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"펩시", "백숙"})
    void 메뉴_이름_예외_테스트(String menuName) {
        // given
        Menu menu = Menu.findMenuByName(menuName);
        int count = 1;

        // when && then
        assertThatThrownBy(() -> new Order(menu, count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }


    @DisplayName("개수가 양수가 아닌 경우 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 개수_예외_테스트(int count) {
        // given
        Menu menu = Menu.findMenuByName("양송이수프");

        // when && then
        assertThatThrownBy(() -> new Order(menu, count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴 이름에 중복이 있는 경우 예외가 발생해야 한다.")
    @Test
    void 메뉴_이름_중복_예외_테스트() {
        assertThatThrownBy(() ->
                new Orders(
                        new ArrayList<>() {{
                            add(new Order(Menu.findMenuByName("양송이수프"), 2));
                            add(new Order(Menu.findMenuByName("해산물파스타"), 2));
                            add(new Order(Menu.findMenuByName("아이스크림"), 3));
                            add(new Order(Menu.findMenuByName("해산물파스타"), 1));
                            add(new Order(Menu.findMenuByName("제로콜라"), 5));
                        }}
                ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("전체 주문 개수가 20개가 넘은 경우 예외가 발생해야 한다.")
    @Test
    void 메뉴_개수_예외_테스트() {
        // when && then
        assertThatThrownBy(() ->
                new Orders(
                        new ArrayList<>() {{
                            add(new Order(Menu.findMenuByName("양송이수프"), 5));
                            add(new Order(Menu.findMenuByName("크리스마스파스타"), 5));
                            add(new Order(Menu.findMenuByName("바비큐립"), 5));
                            add(new Order(Menu.findMenuByName("티본스테이크"), 5));
                            add(new Order(Menu.findMenuByName("제로콜라"), 20));
                        }}
                ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}