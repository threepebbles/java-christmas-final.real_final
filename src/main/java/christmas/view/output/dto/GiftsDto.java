package christmas.view.output.dto;

import java.util.List;

public class GiftsDto {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private final List<GiftDto> gifts;

    public GiftsDto(List<GiftDto> gifts) {
        this.gifts = gifts;
    }

    public List<GiftDto> getGifts() {
        return gifts;
    }

    @Override
    public String toString() {
        if (gifts.isEmpty()) {
            return "없음" + LINE_SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        gifts.forEach(giftDto -> sb.append(giftDto.toString()));
        return sb.toString();
    }
}