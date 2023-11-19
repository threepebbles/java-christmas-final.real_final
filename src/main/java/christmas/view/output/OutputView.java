package christmas.view.output;


import christmas.view.output.dto.DateDto;
import christmas.view.output.dto.DiscountResultsDto;
import christmas.view.output.dto.EventBadgeDto;
import christmas.view.output.dto.EventPlanDto;
import christmas.view.output.dto.GiftsDto;
import christmas.view.output.dto.OrdersDto;
import java.util.function.Consumer;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public void printEventPlan(EventPlanDto eventPlanDTO) {
        printWithLineSeparator(this::printEventPlanHeaderScreen, eventPlanDTO.getDateDto(), 1);
        printWithLineSeparator(this::printOrdersScreen, eventPlanDTO.getOrdersDTO(), 1);
        printWithLineSeparator(this::printTotalPriceBeforeDiscountScreen, eventPlanDTO.getTotalPriceBeforeDiscount(),
                1);
        printWithLineSeparator(this::printGiftScreen, eventPlanDTO.getGiftsDTO(), 1);
        printWithLineSeparator(this::printDiscountResultsScreen, eventPlanDTO.getDiscountResultsDTO(), 1);
        printWithLineSeparator(this::printTotalDiscountScreen, eventPlanDTO.getTotalDiscount(), 1);
        printWithLineSeparator(this::printExpectedPriceAfterDiscountScreen,
                eventPlanDTO.getExpectedPriceAfterDiscount(), 1);
        printWithLineSeparator(this::printEventBadgeScreen, eventPlanDTO.getEventBadgeDto(), 1);
    }

    public void printEventPlanHeaderScreen(DateDto dateDto) {
        System.out.printf(EventPlanScreen.EVENT_PLAN_HEADER_SCREEN,
                dateDto.toString());
    }

    public void printOrdersScreen(OrdersDto ordersDTO) {
        System.out.printf(EventPlanScreen.ORDERS_SCREEN,
                ordersDTO.toString());
    }

    public void printTotalPriceBeforeDiscountScreen(int totalPriceBeforeDiscount) {
        System.out.printf(EventPlanScreen.TOTAL_PRICE_BEFORE_DISCOUNT_SCREEN,
                totalPriceBeforeDiscount);
    }

    public void printGiftScreen(GiftsDto giftsDTO) {
        System.out.printf(EventPlanScreen.GIFTS_SCREEN,
                giftsDTO.toString());
    }

    public void printDiscountResultsScreen(DiscountResultsDto discountResultsDTO) {
        System.out.printf(EventPlanScreen.DISCOUNT_RESULTS_SCREEN,
                discountResultsDTO.toString());
    }


    private void printTotalDiscountScreen(int totalDiscount) {
        System.out.printf(EventPlanScreen.TOTAL_DISCOUNT_SCREEN,
                totalDiscount);
    }

    public void printExpectedPriceAfterDiscountScreen(int expectedPriceAfterDiscount) {
        System.out.printf(EventPlanScreen.EXPECTED_PRICE_AFTER_DISCOUNT_SCREEN,
                expectedPriceAfterDiscount);
    }

    public void printEventBadgeScreen(EventBadgeDto eventBadgeDto) {
        System.out.printf(EventPlanScreen.EVENT_BADGE_SCREEN,
                eventBadgeDto.toString());
    }

    private <T> void printWithLineSeparator(Consumer<T> consumer, T t, int lineSeparatorCount) {
        consumer.accept(t);
        printLineSeparator(lineSeparatorCount);
    }

    public void printLineSeparator(int repeat) {
        final String LINE_SEPARATOR = System.lineSeparator();
        System.out.print(LINE_SEPARATOR.repeat(repeat));
    }
}