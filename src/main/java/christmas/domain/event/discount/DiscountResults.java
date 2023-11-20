package christmas.domain.event.discount;

import christmas.view.output.dto.DiscountResultsDto;
import java.util.ArrayList;
import java.util.List;

public class DiscountResults {
    private List<DiscountResult> discountResults;

    public DiscountResults(List<DiscountResult> discountResults) {
        this.discountResults = discountResults;
    }

    public static DiscountResults createEmptyDiscountResults() {
        return new DiscountResults(new ArrayList<>());
    }

    public DiscountResultsDto toDTO() {
        return new DiscountResultsDto(discountResults.stream()
                .map(DiscountResult::toDto)
                .toList());
    }
}