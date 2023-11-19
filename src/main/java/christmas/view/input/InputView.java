package christmas.view.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.input.dto.DateInputDto;
import christmas.view.input.dto.OrdersInputDto;
import java.util.function.Supplier;

public class InputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다." + LINE_SEPARATOR;
    public static final String ENTER_DAY_OF_VISIT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)" + LINE_SEPARATOR;
    public static final String ENTER_ORDERS_MESSAGE =
            "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)" + LINE_SEPARATOR;

    private final InputValidatorFinder inputValidatorFinder;
    private final InputDtoConverter inputDTOConverter;

    public InputView(InputValidatorFinder inputValidatorFinder, InputDtoConverter inputDTOConverter) {
        this.inputValidatorFinder = inputValidatorFinder;
        this.inputDTOConverter = inputDTOConverter;
    }

    private String scanDayOfVisit() {
        System.out.print(GREETING_MESSAGE);
        System.out.print(ENTER_DAY_OF_VISIT_MESSAGE);
        return Console.readLine();
    }

    public DateInputDto askDateInputDto() {
        return (DateInputDto) retryUntilSuccess(() -> {
            String dayOfVisit = scanDayOfVisit();
            inputValidatorFinder.findByInputType(InputType.DAY_OF_VISIT).validate(dayOfVisit);

            return inputDTOConverter.createDateDTO(dayOfVisit);
        });
    }

    private String scanOrders() {
        System.out.print(ENTER_ORDERS_MESSAGE);
        return Console.readLine();
    }

    public OrdersInputDto askOrdersInputDto() {
        return (OrdersInputDto) retryUntilSuccess(() -> {
            String orders = scanOrders();
            inputValidatorFinder.findByInputType(InputType.ORDERS).validate(orders);
            return inputDTOConverter.createOrdersInputDto(orders);
        });
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private <T> Object retryUntilSuccess(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}