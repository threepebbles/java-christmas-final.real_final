package christmas.view.output.dto;

public class DiscountResultDto {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private final String discountEventName;
    private final int discountAmount;

    public DiscountResultDto(String discountEventName, int discountAmount) {
        this.discountEventName = discountEventName;
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return String.format("%s: -%,d원", discountEventName, discountAmount) + LINE_SEPARATOR;
    }
}