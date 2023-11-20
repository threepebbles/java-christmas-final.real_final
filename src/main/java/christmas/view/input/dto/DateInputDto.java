package christmas.view.input.dto;

import christmas.error.ErrorMessage;
import java.time.DateTimeException;
import java.time.LocalDate;

public class DateInputDto {
    private final LocalDate localDate;

    public DateInputDto(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static DateInputDto createDateInputDTO(String userInput) {
        try {
            final int CURRENT_YEAR = 2023;
            final int CURRENT_MONTH = 12;
            int day = Integer.parseInt(userInput);
            return new DateInputDto(LocalDate.of(CURRENT_YEAR, CURRENT_MONTH, day));
        } catch (DateTimeException | NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.getDateErrorMessage());
        }
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}