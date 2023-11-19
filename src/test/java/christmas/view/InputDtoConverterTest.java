package christmas.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.view.input.dto.DateInputDto;
import christmas.view.input.dto.OrdersInputDto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputDtoConverterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "31"})
    void 방문_날짜_정상_입력_검증_테스트(String dayOfVisit) {
        assertThatCode(() -> DateInputDto.createDateInputDTO(dayOfVisit))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"하나", "일일"})
    void 방문_날짜_예외_입력_검증_테스트(String dayOfVisit) {
        assertThatThrownBy(() -> DateInputDto.createDateInputDTO(dayOfVisit))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"홍차-3,비타오백-5", "비프스테이크-3,티본스테이크-2"})
    void 주문_목록_정상_입력_검증_테스트(String orders) {
        assertThatCode(() -> OrdersInputDto.createOrdersInputDto(orders))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"홍차-하나,비타오백-오", "비프스테이크:3,티본스테이크:2"})
    void 주문_목록_예외_입력_검증_테스트(String orders) {
        assertThatThrownBy(() -> OrdersInputDto.createOrdersInputDto(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }
}