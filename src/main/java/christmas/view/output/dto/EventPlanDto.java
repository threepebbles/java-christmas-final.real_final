package christmas.view.output.dto;

public class EventPlanDto {
    private DateDto dateDto;
    private OrdersDto ordersDTO;
    private int totalPriceBeforeDiscount;
    private GiftsDto giftsDTO;
    private DiscountResultsDto discountResultsDTO;
    private int totalDiscount;
    private int expectedPriceAfterDiscount;
    private EventBadgeDto eventBadgeDto;

    public EventPlanDto(DateDto dateDto, OrdersDto ordersDTO, int totalPriceBeforeDiscount, GiftsDto giftsDTO,
                        DiscountResultsDto discountResultsDTO, int totalDiscount, int expectedPriceAfterDiscount,
                        EventBadgeDto eventBadgeDto) {
        this.dateDto = dateDto;
        this.ordersDTO = ordersDTO;
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
        this.giftsDTO = giftsDTO;
        this.discountResultsDTO = discountResultsDTO;
        this.totalDiscount = totalDiscount;
        this.expectedPriceAfterDiscount = expectedPriceAfterDiscount;
        this.eventBadgeDto = eventBadgeDto;
    }

    public DateDto getDateDto() {
        return dateDto;
    }

    public OrdersDto getOrdersDTO() {
        return ordersDTO;
    }

    public int getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }

    public GiftsDto getGiftsDTO() {
        return giftsDTO;
    }

    public DiscountResultsDto getDiscountResultsDTO() {
        return discountResultsDTO;
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public int getExpectedPriceAfterDiscount() {
        return expectedPriceAfterDiscount;
    }

    public EventBadgeDto getEventBadgeDto() {
        return eventBadgeDto;
    }
}