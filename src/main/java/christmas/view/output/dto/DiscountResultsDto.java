package christmas.view.output.dto;

import java.util.List;

public class DiscountResultsDto {
    public static final String LINE_SEPARATOR = System.lineSeparator();
    private final List<DiscountResultDto> discountResults;

    public DiscountResultsDto(List<DiscountResultDto> discountResults) {
        this.discountResults = discountResults;
    }

    @Override
    public String toString() {
        if (discountResults.isEmpty()) {
            return "없음" + LINE_SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        discountResults.forEach(discountResultDto -> sb.append(discountResultDto.toString()));
        return sb.toString();
    }
}