package christmas.view.output.dto;

public class GiftDto {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private final String giftName;
    private final int count;

    public GiftDto(String giftName, int count) {
        this.giftName = giftName;
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("%s %d개", giftName, count) + LINE_SEPARATOR;
    }
}