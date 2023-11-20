package christmas.view;

import christmas.view.output.OutputView;
import christmas.view.output.dto.DateDto;
import christmas.view.output.dto.DiscountResultDto;
import christmas.view.output.dto.DiscountResultsDto;
import christmas.view.output.dto.EventBadgeDto;
import christmas.view.output.dto.EventPlanDto;
import christmas.view.output.dto.GiftDto;
import christmas.view.output.dto.GiftsDto;
import christmas.view.output.dto.OrderDto;
import christmas.view.output.dto.OrdersDto;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    @Test
    void 이벤트_플래너_출력_테스트() {
        OutputView outputView = new OutputView();
        DateDto dateDto = new DateDto(LocalDate.of(2023, 12, 20));
        OrdersDto ordersDTO = new OrdersDto(
                new ArrayList<>() {{
                    add(new OrderDto("스테이크", 3));
                    add(new OrderDto("콜라", 5));
                }}
        );
        GiftsDto giftsDTO = new GiftsDto(
                new ArrayList<>() {{
                    add(new GiftDto("선물1", 1));
                    add(new GiftDto("선물2", 2));
                }}
        );
        DiscountResultsDto discountResultsDTO = new DiscountResultsDto(
                new ArrayList<>() {{
                    add(new DiscountResultDto("할인1", 1000));
                    add(new DiscountResultDto("할인2", 4020));
                }}
        );
        EventBadgeDto eventBadgeDto = new EventBadgeDto("루돌프");
        EventPlanDto eventPlanDTO = new EventPlanDto(
                dateDto,
                ordersDTO,
                3823982,
                giftsDTO,
                discountResultsDTO,
                123,
                38928,
                eventBadgeDto);

        outputView.printEventPlan(eventPlanDTO);
    }
}