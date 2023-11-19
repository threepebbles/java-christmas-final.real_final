package christmas.domain.event.gift;

import christmas.view.output.dto.GiftsDto;
import java.util.ArrayList;
import java.util.List;

public class Gifts {
    private final List<Gift> gifts;

    public Gifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public static Gifts createEmptyGifts() {
        return new Gifts(new ArrayList<>());
    }

    public GiftsDto toDto() {
        return new GiftsDto(gifts.stream()
                .map(Gift::toDto)
                .toList());
    }

    public int calculateTotalPrice() {
        return gifts.stream()
                .mapToInt(Gift::getPrice)
                .sum();
    }
}