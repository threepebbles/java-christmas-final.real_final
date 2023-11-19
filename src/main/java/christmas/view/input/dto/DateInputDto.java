package christmas.view.input.dto;

import christmas.error.ErrorMessage;
import java.time.LocalDate;
import java.util.Objects;

public class DateInputDto {
    private final LocalDate localDate;

    public DateInputDto(LocalDate localDate) {
        validateNull(localDate);
        this.localDate = localDate;
    }

    private void validateNull(LocalDate localDate) {
        if (Objects.isNull(localDate)) {
            throw new IllegalArgumentException(ErrorMessage.getDateErrorMessage());
        }
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}