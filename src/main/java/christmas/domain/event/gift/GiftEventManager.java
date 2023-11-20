package christmas.domain.event.gift;

public class GiftEventManager {
    private final GiftEvent giftEvent;

    public GiftEventManager(GiftEvent giftEvent) {
        this.giftEvent = giftEvent;
    }

    public Gifts requestGifts() {
        if (giftEvent.isQualified()) {
            return GiftEvent.gifts;
        }
        return Gifts.createEmptyGifts();
    }
}
